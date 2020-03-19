import java.util.Scanner;

public class QuanLyDien {

    public static void main(String[] args) {
        int a;
        boolean ktra = true;
        String[] hoGD = new String[1000];
        long[] soDien = new long[1000];
        long[] soTien = new long[1000];
        Scanner input = new Scanner(System.in);
        System.out.print("nhập số hộ gia đình: ");
        a = input.nextInt();
        input.nextLine();

            int choose;
            System.out.println("            MENU            ");
            System.out.println("1.Tạo một danh sách ghi tên các chủ hộ của các gia đình trong một tổ\n" +
                    "dân phố (danh sách có từ 10 hộ gia đình trở lên).");
            System.out.println("2.Tạo một danh sách ghi số kwh điện tiêu thụ của các hộ gia đình\n" +
                    "tương ứng với danh sách chủ hộ.");
            System.out.println("3.Hiển thị danh sách các hộ gia đình cùng với số kwh điện tiêu thụ và\n" +
                    "số tiền phải trả.");
            System.out.println("4.Hiển thị 3 hộ gia đình có số kwh điện tiêu thụ nhiều nhất.");
            System.out.println("5.Hiển thị các hộ gia đình có chủ hộ tên \"Truong\".");
            System.out.println("6.Sắp danh sách các hộ gia đình theo tên với thứ tự bảng chữ cái");
            System.out.println("7.Sắp xếp danh sách các hộ gia đình theo số kwh điện tăng dần.");
            System.out.println("8.Nhập số 0 để thoát.");
            System.out.println();
        do {
            System.out.print(">>>>>>>>> NHẬP LỰA CHỌN >>>>>>>>>> : ");
            choose = Integer.valueOf(input.nextLine());
            switch ( choose )
            {
                case 1:
                    for (int i=0;i<a;i++)
                    {
                        // danh sách ghi tên các chủ hộ của các gia đình
                        System.out.print("nhập tên hộ thứ "+(i+1)+" : ");
                        hoGD[i] = input.nextLine();
                    }
                    System.out.println();
                    break;
                case 2:
                    for (int i=0;i<a;i++)
                    {
                        // danh sách ghi số kwh điện tiêu thụ của các hộ gia đình
                        System.out.print("nhập số điện của hộ thứ "+(i+1)+" : ");
                        soDien[i] = Long.valueOf(input.nextLine());

                        tinhTien(soDien, soTien, i); //số tiền phải trả tương ứng của các hộ gia đình
                    }
                    System.out.println();
                    break;
                case 3:
                    for (int i=0;i<a;i++)
                    {
                        xuatToanBo(hoGD, soDien, soTien, i); //danh sách hộ gia đình với số điện tiêu thụ và số tiền phải trả
                    }
                    System.out.println();
                    break;
                case 4:
                    if (a>2){
                        xuat3Ho(hoGD, soDien,soTien, a); //3 hộ gia đình có số kwh điện tiêu thụ nhiều nhất
                    }
                    break;
                case 5:
                    checkIn(hoGD, a); // các hộ gia đình có chủ hộ tên "Truong"
                    System.out.println();
                    break;
                case 6:
                    hoGdabc(hoGD,soDien,soTien, a); // hộ gia đình theo tên với thứ tự bảng chữ cái
                    out(hoGD, a);
                    System.out.println();
                    break;
                case 7:
                    soDienTang(hoGD, soDien,soTien, a); //danh sách các hộ gia đình theo số kwh điện tăng dần
                    xuat(hoGD, soDien, a);
                    System.out.println();
                    break;
                default:
                    System.out.println("chào thân ái và tạm biệt ^-^ ");
                    ktra = false;
            }
        } while ( ktra );
    }
    public static void xuatToanBo(String[] crr,long[] arr,long[] brr,int i) // in ra hộ - số điện - số tiền điện
    {
        System.out.println("Hộ gia đình: "+ crr[i] +
                " - số điện: "+ arr[i] + "  -   tổng tiền: " + brr[i]);
    }
    public static void xuat(String[] crr,long[] arr,int n)
    {
        System.out.println("Danh sách các hộ gia đình theo số kwh điện tăng dần: ");
        for (int i=0;i<n;i++)
        {
            System.out.println("Hộ "+ crr[i] +" - "+ arr[i] + " số");
        }
    }
    public static void  xuat3Ho(String[] crr,long[] arr,long[] brr,int n)
    {
        soDienTang(crr, arr,brr, n);
        for (int i=n-1;i >= n-3;i--)
        {
            System.out.println("Hộ gia đình: "+ crr[i] +
                    " - số điện: "+ arr[i]);
        }
    }
    public static void tinhTien(long[] arr,long[] brr,int i)
    {
        if (arr[i]>=0 && arr[i]<=50)
        {
            brr[i] = arr[i] * 1500;
        }
        else if (arr[i]>50 && arr[i]<=100)
        {
            brr[i] = (arr[i]-50) * 1600 + 50 * 1500;
        }
        else if (arr[i]>100 && arr[i]<=200)
        {
            brr[i] = (arr[i]-100) * 1800 + 50 * 1500 + 50 * 1600;
        }
        else if (arr[i]>200 && arr[i]<=300)
        {
            brr[i] = (arr[i]-200) * 2000 + 100 * 1800  + 50 * 1500 + 50 * 1600;
        }
        else if (arr[i]>300)
        {
            brr[i] = (arr[i]-300) * 2500 + 100 * 2000 + 100 * 1800  + 50 * 1500 + 50 * 1600;
        }
    }
    public static void  soDienTang(String[] crr,long[] arr,long[] brr ,int n)
    {
        int i, j;
        long moc1, moc2;
        String tamThoi;
        for (i=0;i<n;i++)
        {
            tamThoi = crr[i];
            moc1 = arr[i];
            moc2 = brr[i];
            j=i-1;
            while(j>=0 && arr[j]>moc1)
            {
                brr[j+1]=brr[j];
                crr[j+1]=crr[j];
                arr[j+1]=arr[j];
                j--;
            }
            crr[j+1]=tamThoi;
            arr[j+1]=moc1;
            brr[j+1]=moc2;
        }
    }
    public static void hoGdabc(String[] crr,long[] arr,long[] brr,int size)
    {
        String[] spl1, spl2;
        String temp;
        Long swap;
        for (int i=0;i<size;i++)
        {
            for (int j=0;j<size-1;j++)
            {
                spl1 = crr[j].split(" ");
                spl2 = crr[j+1].split(" ");
                if ( spl1[spl1.length-1].compareTo(spl2[spl2.length-1])>0 )
                {
                    temp = crr[j];
                    crr[j] = crr[j+1];
                    crr[j+1] = temp;

                    swap = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = swap;

                    swap = brr[j];
                    brr[j] = brr[j+1];
                    brr[j+1] = swap;
                }
                else if ( spl1[spl1.length-1].compareTo(spl2[spl2.length-1])<=0 )
                {
                    continue;
                }
                else if ( spl1[0].compareTo(spl2[0])>0 )
                {
                    temp = crr[j];
                    crr[j] = crr[j+1];
                    crr[j+1] = temp;

                    swap = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = swap;

                    swap = brr[j];
                    brr[j] = brr[j+1];
                    brr[j+1] = swap;
                }
                else if ( spl1[0].compareTo(spl2[0])<=0 ) continue;
            }
        }
    }
    public static void checkIn(String[] crr, int size)
    {
        String[] splt;
        int dem=0;
        String arr = "Truong";
        for (int i=0;i<size;i++)
        {
            splt = crr[i].split(" ");
            if (splt[splt.length-1].compareTo(arr) == 0 )
            {
                dem++;
                System.out.println("Hộ tên 'Truong' thứ "+ dem + " : " + crr[i]);
            }
        }
        if (dem==0) System.out.println("Không có ai tên là \"Truong\"");
    }
    public static void  out(String[] crr, int size)
    {
        System.out.println("danh sách các hộ gia đình theo tên với thứ tự bảng chữ cái:");
        for (int i=0;i<size;i++)
        {
            System.out.println("hộ: "+crr[i]);
        }
    }
}
