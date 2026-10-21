package model;

/**
 * Class yang merepresentasikan data mahasiswa.
 * Menyimpan informasi nama mahasiswa yang terdaftar pada suatu mata kuliah.
 */
public class Student {

    /** Nama lengkap mahasiswa */
    private String name;

    /**
     * Default constructor.
     */
    public Student() {}

    /**
     * Mendapatkan nama mahasiswa.
     * @return nama mahasiswa
     */
    public String getName() {
        return name;
    }

    /**
     * Mengatur nama mahasiswa.
     * @param n nama baru yang akan diset
     */
    public void setName(String n) {
        name = n;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "'}";
    }
}
