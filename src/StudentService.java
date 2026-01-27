public class StudentService {

    DoublyLinkedList<Student> students = new DoublyLinkedList<>();

    // إضافة طالب
    public void addStudent(int id, String name, double grade){
        Student s = new Student(id, name, grade);
        students.addLast(s);
    }

    // عرض كل الطلاب
    public void showStudents(){
        if(students.isEmpty()){
            System.out.println("لا يوجد طلاب");
            return;
        }
        students.display();
    }

    // البحث عن طالب
    public Student searchStudent(int id){
        DoublyLinkedList<Student>.Node<Student> current = students.getHeader();

        while(current != null && current.getData() != null){
            Student s = current.getData();
            if(s.id == id) return s;
            current = current.getNext();
        }
        return null;
    }

    // تعديل طالب
    public boolean updateStudent(int id, String newName, double newGrade){
        Student s = searchStudent(id);
        if(s != null){
            s.name = newName;
            s.grade = newGrade;
            return true;
        }
        return false;
    }

    // حذف طالب
    public boolean deleteStudent(int id){
        DoublyLinkedList<Student>.Node<Student> current = students.getHeader();
        while(current != null && current.getData() != null){
            Student s = current.getData();
            if(s.id == id){
                students.remove(current);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
}