import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentService service = new StudentService();
        Scanner input = new Scanner(System.in);
        int choice;

        do{
            Menu.showMenu();
            choice = input.nextInt();

            switch(choice){
                case 1:
                    System.out.print("رقم الطالب: "); int id = input.nextInt();
                    System.out.print("اسم الطالب: "); String name = input.next();
                    System.out.print("الدرجة: "); double grade = input.nextDouble();
                    service.addStudent(id, name, grade);
                    System.out.println("تمت الإضافة ");
                    break;

                case 2:
                    service.showStudents();
                    break;

                case 3:
                    System.out.print("رقم الطالب: ");
                    Student s = service.searchStudent(input.nextInt());
                    System.out.println(s != null ? s : "الطالب غير موجود ");
                    break;

                case 4:
                    System.out.print("رقم الطالب: "); int uid = input.nextInt();
                    System.out.print("الاسم الجديد: "); String newName = input.next();
                    System.out.print("الدرجة الجديدة: "); double newGrade = input.nextDouble();
                    System.out.println(service.updateStudent(uid,newName,newGrade)?
                            "تم التعديل " : "الطالب غير موجود ");
                    break;

                case 5:
                    System.out.print("رقم الطالب: ");
                    System.out.println(service.deleteStudent(input.nextInt()) ?
                            "تم الحذف " : "الطالب غير موجود ");
                    break;

                case 6:
                    System.out.println("تم الخروج ");
                    break;

                default:
                    System.out.println("خيار غير صحيح");
            }

        }while(choice != 6);

        input.close();
    }
}