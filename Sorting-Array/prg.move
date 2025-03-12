module Sorting {
    use std::vector;
    
    public fun bubble_sort(arr: &mut vector<u64>) {
        let n = vector::length(arr);
        let mut i = 0;
        while (i < n - 1) {
            let mut j = 0;
            while (j < n - i - 1) {
                if (vector::borrow_mut(arr, j) > vector::borrow_mut(arr, j+1)) {
                    let temp = *vector::borrow_mut(arr, j);
                    *vector::borrow_mut(arr, j) = *vector::borrow_mut(arr, j+1);
                    *vector::borrow_mut(arr, j+1) = temp;
                };
                j = j + 1;
            };
            i = i + 1;
        };
    }
    
    public fun print_array(arr: &vector<u64>) {
        vector::for_each(arr, |x| std::debug::print(&x));
    }
}
