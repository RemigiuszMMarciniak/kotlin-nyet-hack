fun main() {
    var test = 0.5
//    12 => 1.5
//    5 => 3.5 => 2.0 => 0.5
//    remaining % remainnig - 1.5
//    5.0 % 5.0 - 1.5
//    5.0 % 3.5 nie
//    3.5 % 3.5 - 1.5
//    (remaining - 2) % 1.5)
    print(((test-2.0)%1.5))
}