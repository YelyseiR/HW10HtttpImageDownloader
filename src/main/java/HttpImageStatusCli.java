import java.util.Scanner;

public class HttpImageStatusCli {
    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();

        System.out.print("Enter HTTP status code: ");
        if (scanner.hasNextInt()) {
            int code = scanner.nextInt();
            try {
                downloader.downloadStatusImage(code);
                System.out.println("Image downloaded successfully.");
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else {
            System.err.println("Please enter a valid number.");
        }
    }

    public static void main(String[] args) {
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();
    }
}
