// Given an array of integers, return indices of the two numbers such that they
// add up to a specific target.
//
// You may assume that each input would have exactly one solution, and you may not
// use the same element twice.
//
// Example:
//
//
// Given nums = [2, 7, 11, 15], target = 9,
//
// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1]

use std::collections::HashMap;

fn two_sum(nums: &[i32], target: i32) -> [i32; 2] {
    let mut lookup = HashMap::new();
    for i in 0..nums.len() {
        lookup.insert(nums[i], i);
    }

    for i in 0..nums.len() {
        let remain = target - nums[i];
        if lookup.contains_key(&remain) {
            return [i as i32, lookup[&remain] as i32];
        }
    }

    unreachable!()
}

#[cfg(test)]
mod tests {
    use super::*;

    #[test]
    fn it_works() {
        let nums = [1, 2, 3, 4, 5, 6, 7];

        assert_eq!(two_sum(&nums, 3), [0, 1]);
        assert_eq!(two_sum(&nums, 9), [1, 6]);
    }
}
