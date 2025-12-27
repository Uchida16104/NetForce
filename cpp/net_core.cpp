#include <cstdlib>
#include <cstdio>
#include <string>

int run(const std::string& cmd) {
    int ret = system(cmd.c_str());
    return ret == -1 ? 1 : 0;
}

int main() {
    run("networksetup -listallhardwareports");

    run("networksetup -setairportpower en0 on");

    run("ipconfig set en0 DHCP");

    run("ping -c 1 8.8.8.8 >/dev/null 2>&1");

    return 0;
}
