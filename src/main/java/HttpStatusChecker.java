import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class HttpStatusChecker {
    private final OkHttpClient httpClient = new OkHttpClient();

    public String getStatusImage(int code) throws Exception {
        String url = "https://http.cat/" + code + ".jpg";
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (response.code() == 404) {
                throw new Exception("Image not found for HTTP status " + code);
            }
            return url;
        }
    }
}
