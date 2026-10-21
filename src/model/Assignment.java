package model;

import exception.NotYetSetException;

/**
 * Class yang merepresentasikan tugas/nilai mahasiswa.
 * Nilai awal diset ke -1 sebagai penanda belum diinputkan.
 * Menggunakan NotYetSetException untuk menjaga integritas data.
 */
public class Assignment {

    /** Nilai tugas; -1 berarti belum diset */
    private double mark = -1;

    /**
     * Default constructor.
     */
    public Assignment() {}

    /**
     * Mendapatkan nilai tugas.
     * Melempar NotYetSetException jika nilai belum diset.
     * @return nilai tugas
     * @throws NotYetSetException jika mark belum diinputkan
     */
    public double getMark() throws NotYetSetException {
        if (mark == -1) {
            throw new NotYetSetException("Mark is not yet set");
        }
        return mark;
    }

    /**
     * Mengatur nilai tugas.
     * @param m nilai yang akan diset (0.0 - 100.0)
     */
    public void setMark(int m) {
        mark = m;
    }

    @Override
    public String toString() {
        return "Assignment{mark=" + (mark == -1 ? "not set" : mark) + "}";
    }
}
