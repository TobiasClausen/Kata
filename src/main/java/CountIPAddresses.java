public class CountIPAddresses {

    public static long ipsBetween(String start, String end) {
        return ipToLong(end) - ipToLong(start);
    }

    private static long ipToLong(String ip) {
        String[] octets = ip.split("\\.");
        long result = 0;
        for (int i = 0; i < 4; i++) {
            result += Long.parseLong(octets[i]) << (8 * (3 - i));
        }
        return result;
    }
}
