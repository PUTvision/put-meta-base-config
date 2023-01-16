DESCRIPTION = "Add own .bashrc file"
LICENSE = "CECILL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/CECILL-2.0;md5=574109ac4bdff61f9c3e0de892ecbd19"

S = "${WORKDIR}"

SRC_URI += "file://bashrc"


do_install () {
  mkdir -p ${D}/home/root
  install -m 0777 ${S}/bashrc                    ${D}/home/root/.bashrc
  install -m 0777 ${S}/bashrc                    ${D}/home/root/.bash_profile
}

FILES:${PN} += "/home/root/.bashrc"
FILES:${PN} += "/home/root/.bash_profile"

do_confiugre() {
  export SHELL = "/bin/bash"
}
