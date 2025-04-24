class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++)
        {
            int size = pq.size();
            if(size >= k && nums[i] > pq.peek()){
                pq.poll();
                pq.add(nums[i]);
            }
            else if(size < k){
                pq.add(nums[i]);
            }
             else{
               continue;
            }  
        }
        return pq.poll();

    }
}