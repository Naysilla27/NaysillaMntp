# NaysillaMntp - Implementasi dan Pengujian Sistem Informasi

> **Universitas Jenderal Achmad Yani** | Laboratorium Jurusan Sistem Informasi

---

## 📋 Identitas

| Nama | NIM | Peran |
|------|-----|-------|
| Naysilla Sifa Aprilianissa | - | Developer |

---

## 📖 Deskripsi Proyek

Repository ini merupakan implementasi **Modul 1 - Latihan Class Diagram** dari mata kuliah **Implementasi dan Pengujian Sistem Informasi (IPSI)**. Proyek ini mengimplementasikan class diagram sederhana dari aplikasi pencatatan perkuliahan menggunakan bahasa pemrograman **Java**.

### Fitur yang Diimplementasikan
- Implementasi semua class sesuai Class Diagram UML dari modul
- Penerapan **enkapsulasi** pada seluruh atribut class
- **Custom Exception Handling** (`NotYetSetException`) pada business logic
- Method cetak mahasiswa: semua, terbaik, dan layak ujian akhir

---

## 🗂️ Struktur Folder

```
NaysillaMntp/
├── src/
│   ├── exception/
│   │   └── NotYetSetException.java   # Custom exception
│   ├── model/
│   │   ├── Student.java              # Class mahasiswa
│   │   ├── Assignment.java           # Class nilai/tugas
│   │   ├── CourseRecord.java         # Class catatan perkuliahan
│   │   └── Course.java               # Class mata kuliah
│   └── main/
│       └── Main.java                 # Entry point / demo program
└── README.md
```

---

## 📐 Class Diagram

```
+-------------------------+
|     NotYetSetException  |
|  (extends Exception)    |
+-------------------------+
| +NotYetSetException(s)  |
+-------------------------+

+-------------------+         +----------------------+
|     Student       |         |     Assignment        |
+-------------------+         +----------------------+
| -name: String     |         | -mark: double = -1    |
+-------------------+         +----------------------+
| +getName()        |         | +getMark(): double    |
| +setName(n)       |         |   throws NotYetSetEx  |
+-------------------+         | +setMark(m: int)      |
                              +----------------------+

+-------------------------------+
|         CourseRecord          |
+-------------------------------+
| -student: Student             |
| -assignments: Vector          |
+-------------------------------+
| +getStudent(): Student        |
| +setStudent(s: Student)       |
| +addAssignment(a: Assignment) |
| +getAssignments(): Enum       |
| +getAverageMark(): double     |
+-------------------------------+

+------------------------------------+
|             Course                 |
+------------------------------------+
| -title: String                     |
| -courseRecords: Vector             |
+------------------------------------+
| +getTitle(): String                |
| +setTitle(t: String)               |
| +addCourseRecord(cr: CourseRecord) |
| +getCourseRecords(): Enumeration   |
| +printCourseStudents()             |
| +printBestStudent()                |
| +printFinalExamStudents()          |
+------------------------------------+
```

---

## 🚀 Cara Menjalankan

### Prasyarat
- Java JDK 8+
- IDE (VS Code / IntelliJ / Eclipse)

### Langkah
```bash
# 1. Clone repository
git clone https://github.com/Naysilla27/NaysillaMntp.git

# 2. Masuk ke direktori
cd NaysillaMntp/src

# 3. Kompilasi semua file Java
javac -d ../out exception/NotYetSetException.java model/Student.java model/Assignment.java model/CourseRecord.java model/Course.java main/Main.java

# 4. Jalankan program
java -cp ../out main.Main
```

---

## 📊 Tabel Traceability Desain-Kode

| Class/Method (Diagram UML) | File Implementasi | Baris |
|----------------------------|-------------------|-------|
| `NotYetSetException` | `src/exception/NotYetSetException.java` | 1-14 |
| `Student.getName()` | `src/model/Student.java` | 24-27 |
| `Student.setName()` | `src/model/Student.java` | 32-35 |
| `Assignment.getMark()` | `src/model/Assignment.java` | 30-36 |
| `Assignment.setMark()` | `src/model/Assignment.java` | 42-44 |
| `CourseRecord.getStudent()` | `src/model/CourseRecord.java` | 40-43 |
| `CourseRecord.setStudent()` | `src/model/CourseRecord.java` | 48-51 |
| `CourseRecord.addAssignment()` | `src/model/CourseRecord.java` | 56-59 |
| `CourseRecord.getAssignments()` | `src/model/CourseRecord.java` | 64-67 |
| `Course.getTitle()` | `src/model/Course.java` | 44-47 |
| `Course.setTitle()` | `src/model/Course.java` | 52-55 |
| `Course.addCourseRecord()` | `src/model/Course.java` | 60-63 |
| `Course.getCourseRecords()` | `src/model/Course.java` | 68-71 |
| `Course.printCourseStudents()` | `src/model/Course.java` | 76-89 |
| `Course.printBestStudent()` | `src/model/Course.java` | 94-113 |
| `Course.printFinalExamStudents()` | `src/model/Course.java` | 118-136 |

---

## 🌿 Branch Strategy

| Branch | Tujuan |
|--------|--------|
| `main` | Branch utama / stable |
| `feature/implementasi-class-diagram` | Implementasi class diagram modul 1 |

---

## 📝 Commit History

Lihat riwayat commit di tab **Commits** pada repository ini.
