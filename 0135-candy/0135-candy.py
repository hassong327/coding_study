class Solution(object):
    def candy(self, ratings):
        """
        :type ratings: List[int]
        :rtype: int
        """
        arr = [1]*len(ratings)

        if(len(ratings)>=3):
            for i in range(1, len(ratings)):
                if(ratings[i]>ratings[i-1]):
                    arr[i] = arr[i-1]+1
        ##############################
        if(len(ratings)>=3):
            for i in range(len(ratings)-2, -1, -1):
                if(ratings[i]>ratings[i+1]):
                    arr[i] = max(arr[i+1]+1, arr[i])
        ##############################
        if(len(ratings)==2):
            if(ratings[0]>ratings[1]):
                arr[0]+=1
            elif(ratings[0]<ratings[1]):
                arr[1]+=1
            return sum(arr)
        if(len(ratings)==1):
            return 1
        print(arr)
        return sum(arr)