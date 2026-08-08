class Solution(object):
    def canCompleteCircuit(self, gas, cost):
        """
        :type gas: List[int]
        :type cost: List[int]
        :rtype: int
        """
        # 가장 먼저 든 생각
        # 가장 큰 위치에서 시작하면? -> cost가 높고 gas가 그 다음부터 적으면? X
        # 시작 위치에서 k -> k+1 단계의 누적 cost보다 항상 높아야 한다.
        # 그러면 for each하되, cost와 gas의 누적 array를 만들고 그 둘을 또 for each로 비교?
        n = len(gas)
        flag = 0
        if(sum(cost)>sum(gas)):
            return -1
        else:
            """
            for i in range(0, n):
                array_gas = gas[i:] + gas[:i]
                array_cost = cost[i:]+cost[:i]
                for j in range(0, n-1):
                    array_gas[j+1] += array_gas[j]
                    array_cost[j+1] += array_cost[j]
                for j in range(0, n):
                    if(array_gas[j]>=array_cost[j]):
                        if(j==n-1):
                            flag = True
                        continue
                    else:
                        break
                if(flag==True):
                    return i
            return -1
            """
            gas_tank = 0
            for i in range(n):
                gas_tank += gas[i] - cost[i]
                if(gas_tank < 0):
                    flag = i + 1
                    gas_tank = 0
            return flag