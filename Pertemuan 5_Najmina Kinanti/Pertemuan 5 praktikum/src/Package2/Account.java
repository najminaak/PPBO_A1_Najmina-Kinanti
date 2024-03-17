package Package2;

public class Account {
    // No Modifier kalau gak dipakein public atau private
    public String username;
    //private
    private String password;

    //kalau gak pake public, dia gak muncul saat di pake di main
    public void printName() {
        System.out.println(username);
    }

    //kalau buat method langsung public atau privat jangan void aja
    public void setPassword(String password) {
        //method enkripsinya
        password += "12345";
        this.password = password;
    }

    //menampilkan password asli
    public String getPassword() {
        String originalPwd = password.replace("12345", " ");
        return originalPwd;
    }


}
