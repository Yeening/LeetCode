public int[] sortTransformedArray(int[] arr, int a, int b, int c) {
        for (int i = 0 ; i < arr.length; i++) {
            arr[i] = (a * arr[i] + b) * arr[i] + c;
        }
        int[] res = new int[arr.length];
        int l = 0, r = arr.length - 1;
        if (a >= 0) {
            int index = arr.length - 1;
            while(index > -1) {
                if (arr[l] < arr[r]) {
                    res[index--] = arr[r--];
                } else {
                    res[index--] = arr[l++];
                }
            }
        } else {
            int index = 0;
            while(index < arr.length) {
                if (arr[l] > arr[r]) {
                    res[index++] = arr[r--];
                } else {
                    res[index++] = arr[l++];
                }
            }
        }
        return res;
    }
