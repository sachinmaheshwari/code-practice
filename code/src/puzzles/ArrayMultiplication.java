package puzzles;

public class ArrayMultiplication {

  public static void main(String[] args) {
    int[] result = new ArrayMultiplication().productExceptSelf(new int[]{0, 0});
    System.out.println(result);
  }

    public int[] productExceptSelf(int[] nums) {
      int totalProduct = 1;
      boolean isZeroPresent = false;
      boolean moreThanOneZero = false;
      for(int i = 0; i < nums.length; i++) {
        if(nums[i] != 0) {
          totalProduct *= nums[i];
        } else if(isZeroPresent) {
          moreThanOneZero = true;
          break;
        } else {
          isZeroPresent = true;
        }
      }

      int[] result = new int[nums.length];

      for(int i = 0; i < nums.length; i++) {
        if(moreThanOneZero) {
          result[i] = 0;
        }
        if(!isZeroPresent) {
          result[i] = totalProduct/nums[i];
        } else if (nums[i] == 0) {
          result[i] = totalProduct;
        } else {
          result[i] = 0;
        }

      }
      return result;

    }

}
