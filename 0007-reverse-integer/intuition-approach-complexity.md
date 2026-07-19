# Java | Optimal O(log n) Solution | Overflow Handling Without Using long ⭐

https://leetcode.com/problems/reverse-integer/solutions/8405383/java-reverse-integer-optimal-overflow-ch-3goj

# Intuition

To reverse an integer, repeatedly extract its last digit using the modulo (`%`) operator and append it to the reversed number. Before appending each digit, ensure that multiplying the current reversed number by `10` and adding the next digit will not cause an integer overflow. If an overflow would occur, return `0` as required by the problem.

# Approach

1. Initialize a variable `rev` to store the reversed integer.
2. Iterate while `x != 0`:
   - Extract the last digit using `x % 10`.
   - Before updating `rev`, check for overflow:
     - If `rev > Integer.MAX_VALUE / 10`, the next multiplication by `10` will overflow.
     - If `rev == Integer.MAX_VALUE / 10`, ensure the next digit is not greater than `7` (the last digit of `2147483647`).
     - If `rev < Integer.MIN_VALUE / 10`, the next multiplication by `10` will underflow.
     - If `rev == Integer.MIN_VALUE / 10`, ensure the next digit is not less than `-8` (the last digit of `-2147483648`).
   - Update the reversed number:
     ```java
     rev = rev * 10 + digit;
     ```
   - Remove the last digit from `x`:
     ```java
     x /= 10;
     ```
3. Return the reversed integer.
4. If an overflow or underflow is detected at any point, return `0`.

# Complexity

- **Time Complexity:** `O(log₁₀(|x|))`
  - Each iteration processes one digit of the input number.

- **Space Complexity:** `O(1)`
  - Only a constant amount of extra space is used.

# Key Insight

- `Integer.MAX_VALUE = 2147483647`
  - If `rev == 214748364`, the largest valid next digit is `7`.
  - Any digit greater than `7` would cause an overflow.

- `Integer.MIN_VALUE = -2147483648`
  - If `rev == -214748364`, the smallest valid next digit is `-8`.
  - Any digit smaller than `-8` would cause an underflow.

By checking these conditions **before** updating the reversed number, we prevent overflow without using a larger data type like `long`.
