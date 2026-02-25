
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DormitoryManagementSystem {
    private static int maxStudentCapacity = 24, i,j;
    private static int currentIndex =0;
    private static int[] roomCount={2,3,2,3,2,2,3,2,3,2};
    private static String[][] roomsCpacity =new String[roomCount.length][];
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static String[] studentName = new String[maxStudentCapacity];
    private static String [] studentID = new String[maxStudentCapacity];
    private static String[] studentMajer = new String[maxStudentCapacity];
    private static int[] roomNUm = new int[roomCount.length];
    private static String  studentid;
    

   


    public static void main(String[] args) throws IOException {
        
        for(i=0;i<roomCount.length;i++){
                roomsCpacity[i] = new String[roomCount[i]];
        }
        while (true) {
            
            showMenu();
            int choose = getIntInput();
            switch(choose){
                case 1:
                    RegisterNewStudent();
                    break;
                case 2:
                    ShowRoomsStatus();
                    break;

                case 3:
                    SearchStudent();
                    break;
                case 4:
                    TransferStudent();
                    break;

                case 5:
                    RemoveStudent();
                    break;

                case 6:
                    ShowAllStudents();
                    break;

                case 7:
                    print("good bye");
            }
            
            
        }
    }



    private static void RegisterNewStudent() throws IOException {
        System.out.println(roomCount.length);
        System.out.println("current index: "+ currentIndex);
        print("enter the name of student" );
        studentName[currentIndex] = getInput();

        print("enetr student ID");
        studentid = getInput();
        
        for(i=0;i<currentIndex;i++){
            if(studentID[i].equals(studentid) ){
                print("this student has been registerd");
                return;
            }
        }
        
        
        studentID[currentIndex]=studentid;

        print("enter  student majer");
        studentMajer[currentIndex]=getInput();

        
        boolean empty =false;
        for(i=0;i<roomsCpacity.length ;i++){
            for(j=0;j<roomCount[i];j++){
                if(roomsCpacity[i][j]==null){
                    empty = true;
                    break;
                }
            }
            if(empty){
                
                break;

            }
        }
        if(empty){
            print("there is empty room");
        }
        else{print("out of cpacity"); return;} 
        print("enter room number");
        int roomIndex = getIntInput();
        setStudent(roomIndex,  studentID[currentIndex]);
        currentIndex++;
        System.out.println("current index: "+ currentIndex);
        


        
    }
    private static void ShowRoomsStatus() {
        int roomnumber=0;
        for(String[] row : roomsCpacity){
            int bedfull=0;
            int remain =0 ;
            for(String bed: row){
                if(bed != null){
                    bedfull++;
                }
            }
            remain = roomCount[roomnumber] - bedfull;
            roomnumber++;
            print(bedfull+ " bed are fulled from  room number: " + roomnumber);
            print(remain+ " bed are remain from  room number: " + roomnumber);
            print("---------------------------------------");
        }
    }

    private static int[] SearchStudent() throws IOException {
        print("Enter the student ID:");
        studentid = getInput();
        checkID(studentid);  
        for(i = 0; i < roomsCpacity.length; i++){
            for(j = 0; j < roomCount[i]; j++){
                if(roomsCpacity[i][j] == null ? studentid == null : roomsCpacity[i][j].equals(studentid)){
                    print("The student with this ID: " + studentid 
                        + " is in room number: " + (i + 1) 
                        + " and bed number: " + (j + 1));
                    return new int[]{i + 1, j + 1};  // برگرداندن همزمان i+1 و j+1
                }
            }
        }
    
    // اگر پیدا نشد
        return new int[]{-1, -1}; // یا مقدار مناسب دیگری
    
    }
    private static void TransferStudent() throws IOException {
        int[] result = SearchStudent();
        print("what room u want to transfer? ");
        int transforRoom = getIntInput();
        if(!checkTheRoom(transforRoom)) return;
        boolean foundEmpty = false;
        for(i=0;i<roomCount[transforRoom-1] ;i++){
            if(roomsCpacity[transforRoom-1][i]==null){
                roomsCpacity[transforRoom-1][i] = studentid;

                foundEmpty =true;
                break;
            }
        }
        if(!foundEmpty) {
            print("this room is full");
            return;
        }
        int oldRoom = result[0]-1;
        int oldBed = result[1] -1;
        roomsCpacity[oldRoom][oldBed] = null ;
        
        
    }
    private static void RemoveStudent() throws IOException {
       int[] result = SearchStudent();
       if(result[0] == -1){  
    
    return;
}
       print("are you sure u want to remove student with this id? "+ studentid);
                    char sure = getcharInput();
                    if(sure != 'y' && sure != 'Y'){
                        return;
                    }
       
       int x,z,m;
       
       
    boolean removedRoom =false, removedInfo = false;
       for(x = 0; x < roomsCpacity.length && !removedRoom; x++){
            for(z = 0; z < roomCount[x] && !removedRoom; z++){
                if(roomsCpacity[x][z] == null ? studentid == null : roomsCpacity[x][z].equals(studentid)){
                        roomsCpacity[x][z] = null;
                        removedRoom = true;
                        break;
                }
                
            }
        }

        for(m=0;m<studentID.length && !removedInfo;m++){
            if(studentID[m] == null ? studentid == null : studentID[m].equals(studentid)){
                studentID[m] = null;
                studentMajer[m] =null;
                studentName[m] =null;
                removedInfo = true;
                break;

            }

        }
        if(removedRoom && removedInfo)
        print("the student with id: "+studentid+" has been removed");
    }


    private static void ShowAllStudents() {
        
    }

    @SuppressWarnings("StringEquality")
    private static void  checkID(String studentid){
       try{for(i=0 ; i< studentID.length; i++){
        if(studentID[i].equals(studentid)){
            return ;
        }
       }
        
        
    }
        catch(Exception e){
            print("this student whith this id has not found");


        }
        
    }
    

    private static void setStudent(int room, String studentID2){
        boolean foundEmpty = false;
        for(i=0;i<roomCount[room-1] ;i++){
            if(roomsCpacity[room-1][i]==null){
                roomsCpacity[room-1][i] = studentID2;

                foundEmpty =true;
                break;
            }
        }
        if(!foundEmpty) {
            print("this room is full");
            return;
        }

    } 


    private static boolean checkTheRoom(int room){
    for(i=0;i<roomCount[room-1] ;i++){
        if(roomsCpacity[room-1][i]==null){
            return true;
        }
    }
    print("this room is full");
    return false;
    }

    
    private static int getIntInput() {
        try {
            return Integer.parseInt(getInput());
            
        } catch (Exception e) {
            System.err.println("enter valid input");
            return 0;
        }
    }
    private static long  getLongInput() {
        try {
            return Long.parseLong(getInput());
            
        } catch (Exception e) {
            System.err.println("enter valid input");
            return 0;
        }
    }

    private static String getInput() throws IOException {
        return bufferedReader.readLine();
        
    }
    
    private static char  getcharInput() {
        try {
            return getInput().charAt(0);
            
        } catch (Exception e) {
            System.err.println("enter valid input");
            return 0;
        }
    }
    

    private static void showMenu() {
        print("1: Register New Student");
        print("2: Show Rooms Status");
        print("3: Search Student by Student ID");
        print("4: Transfer Student to Another Room");
        print("5: Remove Student (Check Out)");
        print("6: Show All Students");
        print("7: Exit");
    }

    private static void print(String string) {
        System.out.println(string);
    }

    
}
