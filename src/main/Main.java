package main;

import exception.NotYetSetException;
import model.*;

/**
 * Class utama untuk menjalankan dan menguji implementasi Class Diagram
 * Aplikasi Pencatatan Perkuliahan.
 *
 * Modul  : Implementasi dan Pengujian Sistem Informasi
 * Nama   : Naysilla Sifa Aprilianissa
 * NIM    : (isi NIM Anda)
 * Kelas  : (isi kelas Anda)
 */
public class Main {

    public static void main(String[] args) {

        // ===== 1. Buat Mata Kuliah =====
        Course course = new Course();
        course.setTitle("Implementasi dan Pengujian Sistem Informasi");

        // ===== 2. Buat Mahasiswa =====
        Student s1 = new Student();
        s1.setName("Naysilla Sifa Aprilianissa");

        Student s2 = new Student();
        s2.setName("Budi Santoso");

        Student s3 = new Student();
        s3.setName("Citra Dewi");

        // ===== 3. Buat Assignment & Set Nilai =====
        Assignment a1 = new Assignment();
        a1.setMark(85);

        Assignment a2 = new Assignment();
        a2.setMark(90);

        Assignment a3 = new Assignment();
        a3.setMark(55); // di bawah threshold ujian akhir

        Assignment a4 = new Assignment();
        // a4 sengaja tidak diset untuk menguji NotYetSetException

        // ===== 4. Buat CourseRecord & Hubungkan =====
        CourseRecord cr1 = new CourseRecord();
        cr1.setStudent(s1);
        cr1.addAssignment(a1);
        cr1.addAssignment(a2);

        CourseRecord cr2 = new CourseRecord();
        cr2.setStudent(s2);
        cr2.addAssignment(a3);

        CourseRecord cr3 = new CourseRecord();
        cr3.setStudent(s3);
        cr3.addAssignment(a4); // assignment belum diset

        // ===== 5. Tambahkan CourseRecord ke Course =====
        course.addCourseRecord(cr1);
        course.addCourseRecord(cr2);
        course.addCourseRecord(cr3);

        // ===== 6. Demonstrasi NotYetSetException =====
        System.out.println("===== Uji NotYetSetException =====");
        try {
            double mark = a4.getMark();
            System.out.println("Nilai: " + mark);
        } catch (NotYetSetException e) {
            System.out.println("Exception berhasil ditangkap: " + e.getMessage());
        }
        System.out.println();

        // ===== 7. Cetak Daftar Mahasiswa =====
        course.printCourseStudents();
        System.out.println();

        // ===== 8. Cetak Mahasiswa Terbaik =====
        course.printBestStudent();
        System.out.println();

        // ===== 9. Cetak Mahasiswa Layak Ujian Akhir =====
        course.printFinalExamStudents();
    }
}
