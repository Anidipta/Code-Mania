use std::io;

fn main() {
    let arr = [1, 2, 3, 4, 5];
    println!("Array: {:?}", arr);

    let mut s = String::new();
    io::stdin().read_line(&mut s).unwrap();
    println!("String: {}", s.trim());
}
