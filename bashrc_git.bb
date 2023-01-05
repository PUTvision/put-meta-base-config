DESCRIPTION = "Add own .bashrc file"
LICENSE = "CECILL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/CECILL-2.0;md5=574109ac4bdff61f9c3e0de892ecbd19"

S = "${WORKDIR}"

SRC_URI += "file://bashrc"


do_install () {
  mkdir -p ${D}/home/put
  install -m 0777 ${S}/bashrc                    ${D}/home/put/.bashrc

}

pkg_postinst_${PN} () {
  chmod -R 775 ${D}/home/
  chown put:put -R ${D}/home/
}

FILES:${PN} += "/home/put/.bashrc"

do_confiugre() {
  export SHELL = "/bin/bash"
}
