package assignment7;


public class question5 {

	public void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num1 = {1,2};
		int[] num2 = {3,4};
		double res = this.findMedianSortedArrays(num1, num2);
		System.out.println(res);

	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // nums1 and nums2 are not empty
        int m = nums1.length;
        int n = nums2.length;
        boolean isEven = ((m+n)%2 == 0);
        if(m > n)
            return findMedian(nums1,nums2,isEven);
        else
            return findMedian(nums2,nums1,isEven);
    }
    public double findMedian(int[] longArray, int[] shortArray, boolean isEven){
        // shortArray is A, A's length is m
        // longArray is B , B's length is n
        int m = shortArray.length;
        int n = longArray.length;
        int imin = 0;
        int imax = m;
        double left_max;
        double right_min;
        while(imin <= imax){
            int i = (imin + imax)/2;
            int j = (m + n)/2 - i;
            // if i<m and m < n, then we can calculate j>0
            // if i>0 and m < n, then we can calculate j<n
            if(i<m && longArray[j-1] > shortArray[i])  imin = i+1;
            else if (i>0 && shortArray[i-1] > longArray[j]) imax = i-1;
            else{
                //here, if isEven : median = (max(A[i-1],B[j-1]) + min(A[i],B[i])) / 2
                //      else      : median = min(A[i],B[j])
                //however, i,j maybe equal 0,0 or m,n
                //so, we need to classify them
                if(i==m)        right_min = longArray[j]; 
                else if(j==n)   right_min = shortArray[i];
                else            right_min = Math.min(shortArray[i],longArray[j]);
                
                if(!isEven)     return right_min;
                
                if(i==0)        left_max = longArray[j-1];
                else if(j==0)   left_max = shortArray[i-1];
                else            left_max = Math.max(shortArray[i-1],longArray[j-1]);
            
                return (right_min + left_max) / 2;
            }
        }
        return 0;
    }
		
}
