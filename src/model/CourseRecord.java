package model;

import exception.NotYetSetException;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Class yang merepresentasikan catatan perkuliahan seorang mahasiswa.
 * Menyimpan data mahasiswa beserta daftar assignment yang dimilikinya.
 * Menerapkan enkapsulasi pada atribut student dan assignments.
 */
public class CourseRecord {

    /** Mahasiswa pemilik catatan ini */
    private Student student;

    /** Daftar assignment yang dimiliki mahasiswa */
    private Vector<Assignment> assignments;

    /**
     * Constructor default yang menginisialisasi Vector assignments.
     */
    public CourseRecord() {
        assignments = new Vector<Assignment>();
    }

    /**
     * Mendapatkan data mahasiswa.
     * @return objek Student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Mengatur data mahasiswa.
     * @param s objek Student yang akan diset
     */
    public void setStudent(Student s) {
        student = s;
    }

    /**
     * Menambahkan assignment ke daftar.
     * @param a objek Assignment yang akan ditambahkan
     */
    public void addAssignment(Assignment a) {
        assignments.addElement(a);
    }

    /**
     * Mendapatkan semua assignment dalam bentuk Enumeration.
     * @return Enumeration dari seluruh assignment
     */
    public Enumeration<Assignment> getAssignments() {
        return assignments.elements();
    }

    /**
     * Menghitung rata-rata nilai dari semua assignment yang sudah diset.
     * @return rata-rata nilai, atau 0.0 jika tidak ada nilai valid
     */
    public double getAverageMark() {
        double total = 0;
        int count = 0;
        Enumeration<Assignment> e = getAssignments();
        while (e.hasMoreElements()) {
            Assignment a = e.nextElement();
            try {
                total += a.getMark();
                count++;
            } catch (NotYetSetException ex) {
                // Skip assignment yang belum diset
            }
        }
        return count > 0 ? total / count : 0.0;
    }

    @Override
    public String toString() {
        return "CourseRecord{student=" + (student != null ? student.getName() : "null")
                + ", assignments=" + assignments.size() + "}";
    }
}
