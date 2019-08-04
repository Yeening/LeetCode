## Find two single numbers with bite manipulation
* In first pass, we xor all the numbers, get xor of the two single numbers
  * eg: a: 4(0100), b: 2(0010), XOR: 0110
* We make the xor &= -xor, get the last 1 bit, a and b differs at this bit
  * eg: XOR & - XOR = 0110 & 1010 = 0010
  * -a = 按位取反，再加一
* Now a & XOR = 0, b & XOR = 0010, we can sepreate the two single numbers
