package edu.rmm.nyethack

//enum class StudentStatus {
//    NOT_ENROLLED,
//    ACTIVE,
//    GRADUATED;
//    var courseId:String? = null
//}
sealed class StudentStatus {
    object NotEnrolled : StudentStatus()
    class Active(val courseId:String):StudentStatus()
    object Graduated : StudentStatus()
}
class Student(var status: StudentStatus)

fun main() {
    val student = Student(StudentStatus.Active("Kotlin001"))
    println(studentMessage(student.status))
}
fun studentMessage(status: StudentStatus):String{
    return when(status){
        is StudentStatus.NotEnrolled -> "Enroll on a course..."
        is StudentStatus.Active -> "Welcome on a course: ${status.courseId}"
        is StudentStatus.Graduated -> "Congratulations!"
    }
}
//fun studentMessage(status: StudentStatus):String{
//    return when(status){
//        StudentStatus.NOT_ENROLLED -> "Enroll on a course..."
//        StudentStatus.ACTIVE -> "Hello student!"
//        StudentStatus.GRADUATED -> "Congratulations"
//    }
//}