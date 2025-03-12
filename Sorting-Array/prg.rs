use std::io;

fn print_array(arr: &Vec<i32>, comparisons: usize) {
    println!("Sorted Array: {:?}", arr);
    println!("Comparisons: {}", comparisons);
}

fn bubble_sort(arr: &mut Vec<i32>) {
    let mut comparisons = 0;
    let n = arr.len();
    for i in 0..n - 1 {
        for j in 0..n - i - 1 {
            comparisons += 1;
            if arr[j] > arr[j + 1] {
                arr.swap(j, j + 1);
            }
        }
    }
    print_array(arr, comparisons);
}

fn insertion_sort(arr: &mut Vec<i32>) {
    let mut comparisons = 0;
    let n = arr.len();
    for i in 1..n {
        let key = arr[i];
        let mut j = i;
        while j > 0 && arr[j - 1] > key {
            comparisons += 1;
            arr[j] = arr[j - 1];
            j -= 1;
        }
        arr[j] = key;
    }
    print_array(arr, comparisons);
}

fn selection_sort(arr: &mut Vec<i32>) {
    let mut comparisons = 0;
    let n = arr.len();
    for i in 0..n - 1 {
        let mut min_idx = i;
        for j in i + 1..n {
            comparisons += 1;
            if arr[j] < arr[min_idx] {
                min_idx = j;
            }
        }
        arr.swap(i, min_idx);
    }
    print_array(arr, comparisons);
}

fn main() {
    let original_arr = vec![34, 7, 23, 32, 5, 62];
    
    loop {
        println!("\n1. Bubble Sort\n2. Insertion Sort\n3. Selection Sort\n4. Exit");
        println!("Enter choice:");

        let mut choice = String::new();
        io::stdin().read_line(&mut choice).expect("Failed to read input");
        let choice: u32 = match choice.trim().parse() {
            Ok(num) => num,
            Err(_) => {
                println!("Invalid input!");
                continue;
            }
        };

        let mut arr = original_arr.clone();

        match choice {
            1 => bubble_sort(&mut arr),
            2 => insertion_sort(&mut arr),
            3 => selection_sort(&mut arr),
            4 => break,
            _ => println!("Invalid choice!"),
        }
    }
}
