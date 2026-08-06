class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """

        # 인용수만큼 칸 만들고, 그 인용수에 해당하는 칸에 해당 인용수의 논문이 몇 개인지 적기
        # 0은 제외, 1부터 1000까지
        arr = [0]*1001 
        for num in citations:
            arr[num] += 1

        # 내가 찾으려는건 [i:] 범위의 value 합이 i보다 큰 i들 중에서 가장 큰 i

        # cnt는 끝부터 누적합을 위해서
        cnt = 0
        # 뒤부터 탐색 시작
        for i in range(1000, 0, -1):
            cnt += arr[i]
            # i를 넘는 순간이 가장 큰 i 니까 return
            if cnt >= i:
                return i

        return 0