use std::io;

fn main() {
    let mut input = String::new();
    io::stdin().read_line(&mut input).unwrap();
    let values: Vec<i32> = input.trim().split_whitespace().map(|x| x.parse().unwrap()).collect();
    
    let (a, b) = (values[0], values[1]);

    println!("AND: {}", a & b);
    println!("OR: {}", a | b);
    println!("XOR: {}", a ^ b);
    println!("NOT A: {}", !a);
    println!("Left Shift: {}", a << 1);
    println!("Right Shift: {}", a >> 1);

    let mut bool_input = String::new();
    io::stdin().read_line(&mut bool_input).unwrap();
    let bools: Vec<bool> = bool_input.trim().split_whitespace().map(|x| x.parse().unwrap()).collect();

    println!("Logical AND: {}", bools[0] && bools[1]);
    println!("Logical OR: {}", bools[0] || bools[1]);
    println!("Logical NOT X: {}", !bools[0]);
}
