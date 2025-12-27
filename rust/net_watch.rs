use std::process::Command;
use std::thread;
use std::time::Duration;

fn can_connect() -> bool {
    let status = Command::new("ping")
        .args(&["-c", "1", "google.com"])
        .output();

    match status {
        Ok(output) => output.status.success(),
        Err(_) => false,
    }
}

fn open_browser() {
    let _ = Command::new("open")
        .arg("https://www.google.com")
        .spawn();
}

fn main() {
    for _ in 0..30 {
        if can_connect() {
            println!("Connected Successfully");
            open_browser();
            return;
        }
        thread::sleep(Duration::from_secs(1));
    }

    println!("Network connection not established yet.");
}

