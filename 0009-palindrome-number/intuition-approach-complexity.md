# Java | Brute Force & Optimal Half-Reversal Solution | O(log n) Time | O(1) Space
https://leetcode.com/problems/palindrome-number/solutions/8406861/java-brute-force-optimal-half-reversal-s-8aop

# Brute Force Approach

## Intuition

A palindrome reads the same from left to right and right to left. One straightforward way to verify this is by reversing the entire number and comparing it with the original number. If both numbers are equal, the number is a palindrome; otherwise, it is not.

Since reversing an integer may exceed the range of a 32-bit signed integer, overflow checks must be performed before updating the reversed number.

## Approach

1. If the number is negative, return `false` since negative numbers cannot be palindromes.
2. Reverse the entire integer using the `reverse()` method.
3. Before updating the reversed number:
   - Check whether multiplying the current reversed number by `10` would overflow.
   - Handle both positive and negative overflow cases.
4. Compare the reversed number with the original number.
5. If both are equal, return `true`; otherwise, return `false`.

## Complexity

- **Time Complexity:** `O(log₁₀(n))`
  - Each digit of the number is processed exactly once while reversing.

- **Space Complexity:** `O(1)`
  - Only a constant amount of extra space is used.

---

# Optimal Approach (Reverse Only Half of the Number)

## Intuition

Instead of reversing the entire number, we only need to reverse **half of its digits**.

A palindrome is symmetric about its center. Therefore, if we reverse the second half of the number and compare it with the first half, we can determine whether the number is a palindrome without reversing all of its digits.

For numbers with an odd number of digits, the middle digit does not affect the result, so it can simply be ignored.

This approach is more efficient because it avoids unnecessary work and completely eliminates the possibility of integer overflow.

## Approach

1. Immediately return `false` if:
   - The number is negative.
   - The number ends with `0` but is not `0` itself.
2. Initialize `revHalfNo` to `0`.
3. While the original number is greater than the reversed half:
   - Extract the last digit of the original number.
   - Append it to `revHalfNo`.
   - Remove the last digit from the original number.
4. After the loop:
   - For **even-length** numbers, compare:
     ```java
     x == revHalfNo
     ```
   - For **odd-length** numbers, ignore the middle digit by dividing `revHalfNo` by `10` and compare:
     ```java
     x == revHalfNo / 10
     ```
5. Return `true` if either comparison succeeds; otherwise, return `false`.

## Complexity

- **Time Complexity:** `O(log₁₀(n))`
  - Only half of the digits are reversed. Although this is still `O(log n)`, it performs fewer iterations than the brute-force approach.

- **Space Complexity:** `O(1)`
  - Only a constant amount of extra space is used.

---

# Key Differences

| Feature | Brute Force | Optimal |
|---------|-------------|----------|
| Reverses entire number | ✅ Yes | ❌ No |
| Reverses only half | ❌ No | ✅ Yes |
| Overflow handling required | ✅ Yes | ❌ No |
| Extra space | `O(1)` | `O(1)` |
| Time Complexity | `O(log₁₀(n))` | `O(log₁₀(n))` |
| Interview Preference | Good | ⭐ Recommended |
