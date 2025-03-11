module Demo {
    public fun main() {
        let arr = [1, 2, 3, 4, 5];
        debug!("Array: {:?}", arr);

        let s: vector<u8> = b"Hello".to_vec();
        debug!("String: {:?}", s);
    }
}
