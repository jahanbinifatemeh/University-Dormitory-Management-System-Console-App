
# University Dormitory Management System

![Java](https://img.shields.io/badge/Language-Java-orange)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)

---

## Overview

**University Dormitory Management System** is a console-based Java application designed to manage student dormitory operations efficiently. The system allows university administrators to:

- Register new students
- Track student information
- Assign students to rooms
- Transfer students between rooms
- Remove students (check out)
- Monitor room occupancy status

This project is fully implemented with **custom algorithms and data structures**, without relying on external libraries, demonstrating strong problem-solving and software engineering skills.

---

## Features

1. **Student Registration**
   - Input student name, ID, and major
   - Automatic assignment to available rooms
   - Checks for duplicate student IDs

2. **Room Management**
   - View current occupancy of all rooms
   - Assign and transfer students efficiently
   - Prevent overbooking

3. **Student Search**
   - Locate students by ID
   - Display room and bed numbers

4. **Transfer Students**
   - Move students to different rooms while ensuring capacity rules
   - Automatically updates previous room availability

5. **Remove Students**
   - Safely remove students from the system
   - Update room and student records simultaneously

---

## Data Structures & Algorithm Highlights

- **2D Arrays**: Represent dormitory rooms and bed occupancy.
- **1D Arrays**: Store student information (name, ID, major).
- **Index Tracking**: Maintains current student count and room assignments.
- **Custom Search & Transfer Algorithms**: Efficiently handle student lookup, room assignment, and room transfers.
- **Input Validation**: Prevent invalid entries and handle edge cases.

---

## Project Structure

University-Dormitory-Management-System/
│
├── src/
│ └── uniRoom.java
├── README.md
├── LICENSE
└── .gitignore


---

## Usage

1. Clone the repository:

```bash
git clone https://github.com/<your-username>/University-Dormitory-Management-System.git

2. Compile and run:

javac src/uniRoom.java
java src.uniRoom

3.Follow the console menu to perform operations:
 - Register students
 - Transfer between rooms
 - Remove students
 - View room status

##License

This project is licensed under the MIT License – see the LICENSE
 file for details

##Why This Project Matters

This project demonstrates:

 - Algorithmic thinking: custom solutions for registration, search, transfer, and deletion.
 - Data structure design: using arrays effectively to model real-world dormitory rooms.
 - Software engineering principles: modular design, input validation, and maintainable code.
 - Problem-solving for real scenarios: room capacity checks, duplicate ID handling, and safe transfers.

It’s an excellent showcase for universities, internships, or employers to highlight your programming and logical reasoning skills.
