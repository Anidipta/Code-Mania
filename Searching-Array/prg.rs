use std::io;

fn linear_search(arr: &[i32], key: i32) {
    for (i, &val) in arr.iter().enumerate() {
        if val == key {
            println!("Found at index {}", i);
            return;
        }
    }
    println!("Not found");
}

fn bubble_sort(arr: &mut Vec<i32>) {
    let n = arr.len();
    for i in 0..n {
        for j in 0..n - i - 1 {
            if arr[j] > arr[j + 1] {
                arr.swap(j, j + 1);
            }
        }
    }
    println!("Sorted Array: {:?}", arr);
}

fn interpolation_search(arr: &[i32], key: i32) -> i32 {
    let mut low = 0;
    let mut high = arr.len() - 1;
    while low <= high && key >= arr[low] && key <= arr[high] {
        let pos = low + (((key - arr[low]) * (high - low) as i32) / (arr[high] - arr[low])) as usize;
        if arr[pos] == key {
            return pos as i32;
        }
        if arr[pos] < key {
            low = pos + 1;
        } else {
            high = pos - 1;
        }
    }
    -1
}

fn main() {
    let mut arr = vec![10, 20, 30, 40, 50];
    let mut input = String::new();

    loop {
        println!("1. Linear Search\n2. Bubble Sort\n3. Interpolation Search\n4. Exit");
        input.clear();
        io::stdin().read_line(&mut input).unwrap();
        let choice: i32 = input.trim().parse().unwrap();

        if choice == 4 {
            break;
        }

        if choice == 1 || choice == 3 {
            println!("Enter key to search: ");
            input.clear();
            io::stdin().read_line(&mut input).unwrap();
            let key: i32 = input.trim().parse().unwrap();

            if choice == 1 {
                linear_search(&arr, key);
            } else {
                let result = interpolation_search(&arr, key);
                println!("Found at index: {}", result);
            }
        } else if choice == 2 {
            bubble_sort(&mut arr);
        }
    }
}
