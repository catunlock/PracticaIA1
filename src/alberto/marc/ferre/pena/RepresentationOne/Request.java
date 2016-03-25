package alberto.marc.ferre.pena.RepresentationOne;

/**
 * Created by sunlock on 24/03/16.
 */
public class Request implements Comparable<Request>{
    int userId;
    int fileId;

    public Request(int userId, int fileId) {
        this.userId = userId;
        this.fileId = fileId;
    }

    public Request(Request req) {
        this.userId = req.userId;
        this.fileId = req.fileId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Request request = (Request) o;

        if (userId != request.userId) return false;
        return fileId == request.fileId;

    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + fileId;
        return result;
    }


    @Override
    public int compareTo(Request o) {
        return this.fileId - o.fileId;
    }
}