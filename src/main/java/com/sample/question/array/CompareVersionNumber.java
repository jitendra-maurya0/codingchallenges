package com.sample.question.array;

public class CompareVersionNumber {

    /**
     * Time complexity : O(N + M + \max(N, M))O(N+M+max(N,M)), where NN and MM are lengths of input strings.
     *
     * Space complexity : O(N + M)O(N+M) to store arrays nums1 and nums2.
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int n1 = nums1.length, n2 = nums2.length;

        // compare versions
        int i1, i2;
        for (int i = 0; i < Math.max(n1, n2); ++i) {
            i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
            i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        // the versions are equal
        return 0;
    }
}
