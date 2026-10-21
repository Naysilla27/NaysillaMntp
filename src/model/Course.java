package model;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Class yang merepresentasikan sebuah mata kuliah.
 * Menyimpan judul mata kuliah dan daftar CourseRecord setiap mahasiswa.
 * Menerapkan inheritance polymorphism melalui metode cetak yang dapat di-override.
 */
public class Course {

    /** Judul mata kuliah */
    private String title;

    /** Daftar catatan perkuliahan seluruh mahasiswa yang mengambil course ini */
    private Vector<CourseRecord> courseRecords;

    /**
     * Constructor default yang menginisialisasi Vector courseRecords.
     */
    public Course() {
        courseRecords = new Vector<CourseRecord>();
    }

    /**
     * Mendapatkan judul mata kuliah.
     * @return judul mata kuliah
     */
    public String getTitle() {
        return title;
    }

    /**
     * Mengatur judul mata kuliah.
     * @param t judul baru
     */
    public void setTitle(String t) {
        title = t;
    }

    /**
     * Menambahkan CourseRecord ke daftar.
     * @param cr objek CourseRecord yang akan ditambahkan
     */
    public void addCourseRecord(CourseRecord cr) {
        courseRecords.addElement(cr);
    }

    /**
     * Mendapatkan seluruh CourseRecord dalam bentuk Enumeration.
     * @return Enumeration dari seluruh CourseRecord
     */
    public Enumeration<CourseRecord> getCourseRecords() {
        return courseRecords.elements();
    }

    /**
     * Mencetak seluruh mahasiswa yang mengambil course ini beserta rata-rata nilai.
     * Implementasi enkapsulasi: data internal diakses hanya lewat getter.
     */
    public void printCourseStudents() {
        System.out.println("=== Daftar Mahasiswa Course: " + title + " ===");
        Enumeration<CourseRecord> e = getCourseRecords();
        if (!e.hasMoreElements()) {
            System.out.println("  Tidak ada mahasiswa terdaftar.");
        }
        while (e.hasMoreElements()) {
            CourseRecord cr = e.nextElement();
            Student s = cr.getStudent();
            if (s != null) {
                System.out.println("  - " + s.getName()
                        + " | Rata-rata Nilai: " + cr.getAverageMark());
            }
        }
    }

    /**
     * Mencetak mahasiswa dengan nilai rata-rata terbaik pada course ini.
     */
    public void printBestStudent() {
        System.out.println("=== Mahasiswa Terbaik di Course: " + title + " ===");
        double bestAvg = -1;
        Student bestStudent = null;

        Enumeration<CourseRecord> e = getCourseRecords();
        while (e.hasMoreElements()) {
            CourseRecord cr = e.nextElement();
            double avg = cr.getAverageMark();
            if (avg > bestAvg) {
                bestAvg = avg;
                bestStudent = cr.getStudent();
            }
        }

        if (bestStudent != null) {
            System.out.println("  Nama  : " + bestStudent.getName());
            System.out.println("  Nilai : " + bestAvg);
        } else {
            System.out.println("  Belum ada data mahasiswa.");
        }
    }

    /**
     * Mencetak mahasiswa yang layak mengikuti ujian akhir.
     * Kriteria: rata-rata nilai >= 60.
     */
    public void printFinalExamStudents() {
        System.out.println("=== Mahasiswa Layak Ujian Akhir di Course: " + title + " ===");
        System.out.println("  (Kriteria: rata-rata nilai >= 60)");
        boolean found = false;

        Enumeration<CourseRecord> e = getCourseRecords();
        while (e.hasMoreElements()) {
            CourseRecord cr = e.nextElement();
            double avg = cr.getAverageMark();
            if (avg >= 60) {
                Student s = cr.getStudent();
                if (s != null) {
                    System.out.println("  - " + s.getName() + " (Nilai: " + avg + ")");
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("  Tidak ada mahasiswa yang memenuhi syarat.");
        }
    }

    @Override
    public String toString() {
        return "Course{title='" + title + "', records=" + courseRecords.size() + "}";
    }
}
