package pjtTest;

public class MainClass {
    // 프로그램을 가장 먼저 실행하는 메소드
    public static void main(String[] args) {
        // sysout : Sh+Space
        System.out.println("Hello Java World~~~");
        System.out.println("--------------------------------------------------");

        //변수
        char    c = 'c';                //2byte
        int     i = 10;                 //4byte
        double  d = 10.123;             //8byte
        boolean b = false;              //1byte
        String  s = "Hello Java World";
        
        System.out.println("문자 char     : " + c);
        System.out.println("숫자 int      : " + i);
        System.out.println("실수 double   : " + d);
        System.out.println("논리 boolean  : " + b);
        System.out.println("문자열 String : " + s);
        System.out.println("--------------------------------------------------");

        //형변환
        byte by  = 10;
        int  in1 = 0;
        int  in2 = 100;
        int  in3 = 1000000;

        //자동형변환 : 작은 데이터형 -> 큰 데이터형
        in1 = by;
        System.out.println("by : " + by + ", in = byte : " + in1);

        //명시적형변환 : 데이터가 누실될 수 있음
        by = (byte)in2;
        System.out.println("in : " + in2 + ", by = (byte)in : " + by);
        by = (byte)in3;
        System.out.println("in : " + in3 + ", by = (byte)in : " + by);
        System.out.println("--------------------------------------------------");

        //특수문자
        System.out.println("탭   :  Good\tMornig~");
        System.out.println("개행 : Good\nMornig~");
        System.out.println("\'   : Good\'Mornig~\'");
        System.out.println("\"   : Good\"Mornig~\"");
        System.out.println("\\   : Good\\Mornig~\\");
        System.out.println("--------------------------------------------------");

        //서식(포멧)
        System.out.printf("num(10진수)     : %d\n", 30);
        System.out.printf("num(8 진수)     : %o\n", 30);
        System.out.printf("num(16진수)     : %x\n", 30);
        System.out.printf("num(실수Float)  : %f\n", 1.12345678f);
        System.out.printf("num(실수Double) : %f\n", 1.12345678d);
        System.out.printf("소문자 \'%c\'의 대문자는 \'%c\'입니다.\n", 'a', 'A');
        System.out.printf("소문자 \'%s\'의 대문자는 \'%s\'입니다.\n", "java", "JAVA");
        System.out.println("--------------------------------------------------");

        //서식(정렬)
        System.out.printf("왼쪽   정렬 : %d\n왼쪽   정렬 : %d\n왼쪽   정렬 : %d\n", 123, 1234,12345);
        System.out.printf("오른쪽 정렬 : %5d\n오른쪽 정렬 : %5d\n오른쪽 정렬 : %5d\n", 123, 1234,12345);
        System.out.printf("float         : %f\n소수점(0자리) : %.0f\n소수점(2자리) : %.2f\n소수점(4자리) : %.4f\n", 1.23, 1.23, 1.23, 1.23);
        System.out.println("--------------------------------------------------");

        //산술 연산자
        int x, y = 0;
        x = 10; y = 10;
        System.out.printf("x + y = %d + %d = %d\n", x, y, x + y);
        System.out.printf("x - y = %d - %d = %d\n", x, y, x - y);
        System.out.printf("x * y = %d * %d = %d\n", x, y, x * y);
        System.out.printf("x / y = %d / %d = %d\n", x, y, x / y);
        System.out.printf("x %% y = %d %% %d = %d\n", x, y, x % y);
        
        //복합 대입 연산자
        x = 10;
        System.out.printf("x += 10 : %d += 10 : %d\n", x, x += 10);
        System.out.printf("x -= 10 : %d -= 10 : %d\n", x, x -= 10);
        System.out.printf("x *= 10 : %d *= 10 : %d\n", x, x *= 10);
        System.out.printf("x /= 10 : %d /= 10 : %d\n", x, x /= 10);
        System.out.printf("x %%= 10 : %d %%= 10 : %d\n", x, x %= 10);

        //증감 연산자
        x = 1;
        System.out.printf("++x = ++%d = %d, x = %d\n", x, ++x, x);
        System.out.printf("x++ = %d++ = %d, x = %d\n", x, x++, x);
        System.out.printf("--x = --%d = %d, x = %d\n", x, --x, x);
        System.out.printf("x-- = %d-- = %d, x = %d\n", x, x--, x);
        
        //관계 연산자
        x = 10; y = 10;
        System.out.printf("x >  y : %d >  %d : %b\n", x, y, x >  y);
        System.out.printf("x >= y : %d >= %d : %b\n", x, y, x >= y);
        System.out.printf("x <  y : %d <  %d : %b\n", x, y, x <  y);
        System.out.printf("x <= y : %d <= %d : %b\n", x, y, x <= y);
        System.out.printf("x == y : %d == %d : %b\n", x, y, x == y);
        System.out.printf("x != y : %d != %d : %b\n", x, y, x != y);
        
        //논리 연산자
        boolean b1 = true;
        boolean b2 = false;
        System.out.printf("b1 && b2 : %b && %b : %b\n", b1, b2, b1 && b2);
        System.out.printf("b1 || b2 : %b && %b : %b\n", b1, b2, b1 || b2);
        System.out.printf("!b1      : !%b      : %b\n", b1, !b1);
        
        //삼항 연산자
        x = 10; y = 20;
        System.out.printf("x > y ? 100 : 200 => %d > %d ? 100 : 200 => %d\n", x, y, (x > y) ? 100 : 200);
        System.out.printf("x < y ? 100 : 200 => %d < %d ? 100 : 200 => %d\n", x, y, (x < y) ? 100 : 200);
        
        //비트 연산자
        // & : AND, | : OR, ^ : XOR
        System.out.println("--------------------------------------------------");
        
        //배열
        int[] arr1 = new int[5];
        arr1[0] = 100; arr1[1] = 200; arr1[2] = 300;
        System.out.printf("arr[0] = %d, arr[1] = %d, arr[2] = %d\n", arr1[0], arr1[1], arr1[2]);

        int[] arr2 = {10, 20, 30};
        System.out.printf("arr[0] = %d, arr[1] = %d, arr[2] = %d\n", arr2[0], arr2[1], arr2[2]);


        
        
        
        

        System.out.println("--------------------------------------------------");
    }
}
