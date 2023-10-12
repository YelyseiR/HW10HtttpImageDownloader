import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.FileOutputStream;
import java.io.IOException;

public class HttpStatusImageDownloader {
    private final OkHttpClient httpClient = new OkHttpClient();

    public void downloadStatusImage(int code) throws Exception {
        HttpStatusChecker checker = new HttpStatusChecker();
        String imageUrl = checker.getStatusImage(code);

        Request request = new Request.Builder()
                .url(imageUrl)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                try (FileOutputStream fos = new FileOutputStream(code + ".jpg")) {
                    fos.write(response.body().bytes());
                }
            } else {
                throw new Exception("Failed to download image for HTTP status " + code);
            }
        }
    }
}

