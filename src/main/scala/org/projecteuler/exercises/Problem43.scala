package org.projecteuler.exercises

object Problem43 {

  def makeNumber(a: Char, b: Char, c: Char): Int = {
    a.asDigit * 100 + b.asDigit * 10 + c.asDigit
  }

  def isValid(perm: String): Boolean = {
    makeNumber(perm(1), perm(2), perm(3)) % 2 == 0 &&
      makeNumber(perm(2), perm(3), perm(4)) % 3 == 0 &&
      makeNumber(perm(3), perm(4), perm(5)) % 5 == 0 &&
      makeNumber(perm(4), perm(5), perm(6)) % 7 == 0 &&
      makeNumber(perm(5), perm(6), perm(7)) % 11 == 0 &&
      makeNumber(perm(6), perm(7), perm(8)) % 13 == 0 &&
      makeNumber(perm(7), perm(8), perm(9)) % 17 == 0
  }

  def compute: BigInt = {
    var x = BigInt(0)
    "0123456789".permutations dropWhile (perm => { perm.substring(0, 1) == "0" }) dropWhile (perm => { !isValid(perm) }) foreach (number => { x = x + BigInt(number) })
    x
  }
}