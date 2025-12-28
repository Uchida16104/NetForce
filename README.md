# NetForce

## Overview

NetForce is a lightweight, multi-language offline support and network recovery tool for macOS.  
It is designed to continue offline tasks while automatically attempting network recovery, and to notify the user once connectivity is restored.

The system integrates:
- A Java AWT GUI for user interaction
- Python for offline task execution and logging
- C++ for low-level network interface control
- Rust for network connectivity monitoring and browser launching

All components are orchestrated from a single GUI entry point.

---

## Requirements

- macOS
- Java (JDK 8 or later)
- Python 3
- Rust (compiled binary)
- C++ compiler (for building `net_core`)
- Network permissions to execute `networksetup`, `ipconfig`, and `ping`

Required commands must be available in the system PATH:
- `python3`
- `ping`
- `networksetup`
- `ipconfig`
- `open`

---

## Usage

1. Build native components:
   - Compile `net_core.cpp` to generate `cpp/net_core`
   - Compile `net_watch.rs` to generate `rust/net_watch`

2. Ensure execution permissions:
   ```sh
   chmod +x cpp/net_core
   chmod +x rust/net_watch
   ````

3. Launch NetForce:
* GUI

   ```sh
   java NetForceGUI
   ```

* CUI

  ```sh
  java NetForceApp
  ```
  
4. Click **"Start Offline + Network Recovery"** in the GUI.

Behavior:

* Offline tasks are executed and logged to `offline.log`
* Network interfaces are force-enabled and reconfigured
* Connectivity is checked periodically
* When a connection is established, the default browser opens Google and logs:

  ```
  Connected Successfully
  ```

---

## License

[MIT License](https://github.com/Uchida16104/NetForce?tab=MIT-1-ov-file)

---

## Developer

[Hirotoshi Uchida](https://hirotoshiuchida.onrender.com)
