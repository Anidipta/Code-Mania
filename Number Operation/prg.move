module LogicalBinaryOps {
    public fun main() {
        let a: u64 = 5;
        let b: u64 = 3;

        let and_result = a & b;
        let or_result = a | b;
        let xor_result = a ^ b;
        let not_a = !a;
        let left_shift = a << 1;
        let right_shift = a >> 1;

        debug!("AND: {}", and_result);
        debug!("OR: {}", or_result);
        debug!("XOR: {}", xor_result);
        debug!("NOT A: {}", not_a);
        debug!("Left Shift: {}", left_shift);
        debug!("Right Shift: {}", right_shift);
    }
}
