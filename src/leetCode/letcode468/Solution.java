package leetCode.letcode468;


public class Solution {
    public String validIPAddress(String IP) {
        if (IP.indexOf('.') != -1) {
            if (isIpv4(IP)) return "IPv4";
        }
        if (IP.indexOf(':') != -1) {
            if (isIpv6(IP)) {
                return "IPv6";
            }
        }
        return "Neither";
    }

    public static boolean isIpv4(String string) {
        if (string.endsWith(".") || string.endsWith(":")) return false;
        if (string.startsWith(".") || string.startsWith(":")) return false;
        String[] strings = string.split("\\.");
        if (strings.length != 4) return false;
        for (String s : strings) {
            if (s.equals("")) return false;
        }
        for (String s : strings) {
            if (s.startsWith("0") && s.length() != 1) return false;
            else {
                char[] chars = s.toCharArray();
                StringBuilder stringBuilder = new StringBuilder();
                for (char c : chars) {
                    if (!Character.isDigit(c)) return false;
                    stringBuilder.append(c);
                }
                if (stringBuilder.toString().length()>3) return false;
                if (Integer.parseInt(stringBuilder.toString())>255) return false;
            }
        }
        return true;
    }

    public static boolean isIpv6(String string) {
        if (string.indexOf('.') != -1) return false;
        if (string.endsWith(".") || string.endsWith(":")) return false;
        if (string.startsWith(".") || string.startsWith(":")) return false;
        String[] strings = string.split(":");
        if (strings.length != 8) return false;
        for (String s : strings) {
            if (s.length() > 4) return false;
            if (s.equals("")) return false;
            char[] c = s.toCharArray();
            for (char tmp : c) {
                if ((Character.isUpperCase(tmp) && tmp > 'F') || (Character.isLowerCase(tmp) && tmp > 'f'))
                    return false;
            }
        }
        return true;
    }
}
