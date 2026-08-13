class Solution(object):
    def fullJustify(self, words, maxWidth):
        """
        :type words: List[str]
        :type maxWidth: int
        :rtype: List[str]
        """
        # string concat + space concat 함수
        # words는 더해야 하는 words의 리스트
        # space는 띄어쓰기 수가 적힌 리스트 (3, 2, 2면 3번 2번 2번 space를 4개 단어 사이에 넣는다. 
        # flag가 True면 마지막 줄이라는 의미. 마지막 줄은 왼쪽 정렬.)
        def str_concat(words, spaces, flag = False):
            sentences = ""
            if flag == False:
                for i in range(0, len(words)):
                    sentences += words[i] + " "*(spaces[i] if i<len(spaces) else 0)
                return sentences
            else:
                sentences = " ".join(words)
                sentences += " "*(maxWidth-len(sentences))
                return sentences


        # 단어 길이 먼저 파악 list
        # 단어를 순차적으로 더하고, 단어 개수 -1의 수를 더해야 함.
        strs = []           # 최종 return 할 문장 리스트
        num_words = []      # words 속 단어들의 길이가 적힌 리스트. 동일한 index에 해당 단어의 길이가 적힘
        
        
        sentences = []      # strs의 한 문장에 들어갈 단어들이 적힐 리스트
        spaces = []         # strs의 한 문장에 들어갈 띄어쓰기의 개수가 적힌 리스트, 단어들 사이 사이에 들어갈 예정
        for i in words:
            num_words.append(len(i))

        count_width = 0     # 기본적인 띄어쓰기가 적용되는... 즉 최소 띄어쓰기 1은 적용되는 경우.
        count_num = 0       # 
        for i in range(len(words)):
            if(count_width+len(words[i])+count_num <= maxWidth):
                count_width += len(words[i])
                count_num += 1
                sentences.append(words[i])
            else:
                if(count_num == 1):
                    line = sentences[0]
                    line += " " * (maxWidth-len(line))
                    strs.append(line)
                else:
                    n = maxWidth-count_width
                    n = n//(count_num-1)
                    
                    idx = 0
                    spaces = [n]*(count_num-1)
                    while(True):
                        if((sum(spaces)+count_width) >= maxWidth):
                            break
                        else:
                            print(idx, spaces[idx])
                            spaces[idx]+=1
                            idx+=1
                

                    # 무언가의 연산
                    strs.append(str_concat(words = sentences, spaces = spaces))

                # count width랑 num 0으로 초기화
                print(sentences)
                print(spaces)
                sentences = [words[i]]
                count_width = len(words[i])
                count_num = 1
                spaces = []
        strs.append(str_concat(words = sentences, spaces = spaces, flag = True))
        
        return strs
