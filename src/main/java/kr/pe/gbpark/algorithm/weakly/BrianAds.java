package kr.pe.gbpark.algorithm.weakly;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BrianAds {

	public String solution(String sentence) {
		String answer = "";
		final int NORMAL = 0;
		final int BETWEEN = 1;
		final int WORD = 2;
		final int MIX = 3;
		final int WAIT = -1;
		final int SPECIAL = -2;
		final String INVALID = "invalid";
		int start = 0;
		int length = sentence.length();
		int mode = NORMAL;
		int betweenEnd = 0;
		char save = ' ';
		char mix = ' ';
		Queue<int[]> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		Set<Character> used = new HashSet<>();

		for (int i = 0; i < length; i++) {
			char curr = sentence.charAt(i);
			if((int) curr > 96 && (int) curr < 123) {
				switch (mode) {
					case NORMAL:
						if(!used.add(curr)) return INVALID;

						if (start == i) { // 소문자로 시작 - 2번룰
							mode = WORD;
						} else { // 앞의 대문자가 있는 소문자 - WEWSa , a 상태로 WAIT
							mode = WAIT;
							start = i;
						}
						save = curr;
						break;
					case WORD:
						if(save == curr && i - start > 1) { // aWEFQWF a
							queue.add(new int[]{start, i, WORD});
							mode = NORMAL;
						} else if (i - start == 2 && save != curr ) { // aWb 혼합 룰 모드로
							if(!used.add(curr)) return INVALID;
							mode = MIX;
							mix = curr;
							betweenEnd = i;
						} else return INVALID; // aBDFDG b  or aa - fail;
						break;
					case BETWEEN: // special 에서 넘어온 경우 만 존재
						if(save == curr) {
							if (i - betweenEnd != 2) return INVALID; // XaFaGQa or XaFaa - fail
							betweenEnd = i;
						} else { // XaVaBb
							if (i - betweenEnd == 1) return INVALID; // XaFa b 다른소문자가 바로 등장 - fail
							if(!used.add(curr)) return INVALID; // XaFaF FSFFS b  - between 처리
							save = curr;
							queue.add(new int[] {start, betweenEnd + 1 ,BETWEEN});
							start = i;
							if (i - betweenEnd == 2) { // XaFaX b 바로등장 - WORD로 변경
								mode = WORD;
							} else {
								mode = WAIT;
							}
						}
						break;
					case SPECIAL: // X aBa 뒤에서 소문자 출현 한 경우
						if(save == curr) {
							if(i - start == 4) { // X aBaDa - between 으로 변경, start 한칸 앞으로
								mode = BETWEEN;
								start = start-1;
								betweenEnd = i;
							} else return INVALID; // aBaa 또는 aBaSDa- 불가능
						} else { // X aBa 뒤에서 다른 소문자 - a는 WORD 로 처리
							if(!used.add(curr)) return INVALID;
							save = curr;
							if(i - start == 3) { // X aBa b 인경우 - b는 무조건 WORD
								queue.add(new int[] {start, start+2, WORD});
								mode = WORD;
							} else { // X aBa A b 인경우 - b를 wait 로
								queue.add(new int[] {start-1, start+3, BETWEEN});
								mode = WAIT;
							}
							start = i;
						}
						break;
					case WAIT:
						if(i - start <= 1) return INVALID; // Z ab - 불가능
						if(save == curr) {
							if(i - start > 2) { // Z aWHa 간격이 2보다 큼 - 2번 룰 적용 후 완료
								queue.add(new int[] {start, i , WORD});
								start = i +1;
								mode = NORMAL;
							} else mode = SPECIAL; // X aZa 의 형태 - special 상태
						} else { // 다른 소문자가 2번째로 출현 - X aZFSb - a 를 between 처리
							if(!used.add(curr)) return INVALID;
							if (i - start == 2) { // X aZb - Mix 모드로
								mode = MIX;
								mix = curr;
								betweenEnd = i;
							} else { // X aZ Ab a 는 Between 확정 b는 다시 WAIT
								queue.add(new int[] {start-1, start+1, BETWEEN});
								save = curr;
								start = i;
							}
						}
						break;
					case MIX: //  aSbS ~~~
						if (i-betweenEnd == 2) {
							if(mix == curr) { // aXbDb - 계속
								betweenEnd = i;
							} else if(save == curr) { // aXbDbSa - MIX 완료
								queue.add(new int[] {start, i, MIX});
								start = i + 1;
								mode = NORMAL;
							} else return INVALID; // aSbSbSz
						}else return INVALID; // aSbSSb or aSbb
						break;
				}
			} else if((int) curr < 65 || (int) curr > 90) return INVALID; // 대문자가 아닌경우
		}

		if(mode == SPECIAL) { // X aSa FEFEF
			if(start < length - 3) {
				queue.add(new int[] {start - 1, start + 3 ,BETWEEN});
			} else {
				queue.add(new int[] {start, start + 2 ,WORD});
			}
		} else if(mode == BETWEEN) {
			if(betweenEnd == length - 1) return INVALID; //X aAaEa - fail
			queue.add(new int[]{start, betweenEnd + 1, BETWEEN});
		} else if(mode == WAIT) {
			if(start == length -1) return INVALID; // D a - fail
			queue.add(new int[]{start - 1, start + 1, BETWEEN});
		} else if(mode == WORD || mode == MIX) return INVALID; // aWEA or WaWbS- fail

		start = 0;
		while(!queue.isEmpty()) {
			int[] poll = queue.poll();
			int begin = poll[0];
			int finish = poll[1] + 1;
			if(begin > start) sb.append(sentence.substring(start,begin)).append(" ");

			if(poll[2] == BETWEEN) {
				sb.append(sentence.substring(begin,finish).replaceAll(sentence.substring(begin + 1, begin + 2), ""));
			} else if(poll[2] == WORD) {
				sb.append(sentence.substring(begin + 1,finish - 1));
			} else if(poll[2] == MIX) { // aSbFbGa
				sb.append(sentence.substring(begin + 1,finish - 1).replaceAll(sentence.substring(begin + 2, begin + 3), ""));
			}

			start = finish;
			sb.append(" ");
		}

		if(start < length) {
			answer = sb.append(sentence.substring(start, length)).toString();
		} else {
			answer = sb.substring(0,sb.length() -1);
		}

		return answer;
	}
}

/*

	카카오스토리의 개발자 브라이언에게 최근 고민이 생겼다. 하루에도 수백만 명이 사용하는 서비스답게 사람들이 많이 보는 글에 광고성 댓글을 달아 불쾌감을 유발하는 사용자가 증가하고 있는데, 신고를 받은 글이 광고글인지를 운영자가 판단하여 차단하는 시스템으로는 빠르게 늘어나는 광고글을 처리하기 어렵기 때문이다. 그래서 브라이언은 신고된 글이 광고글인지를 자동으로 판단하는 시스템을 만들었다. 이제 사용자가 광고글을 보고 신고하면 그 글이 광고글로 판단된 경우 자동으로 차단된다! 드디어 깨끗한 카카오스토리를 만들었다는 기쁨도 잠시, 광고글을 올리는 사람들이 자동 차단 시스템을 회피할 수 있는 방법을 찾기 시작했고, 얼마 지나지 않아 광고 문구 사이에 특수문자를 넣으면 차단되지 않는다는 점이 알려지게 되었다. 즉, 아래와 같은 식으로 작성하면 광고글 차단이 적용되지 않는다.

		♚프☆렌☆즈☆레☆이☆싱♚★사전예약★진행중
		$지금$예약시♜이모티콘♜100%※증정※
		★라이언★카트♨전원♨획@득@기@회
즉시이동 http://...
생각지 못한 광고글 패턴에 당황하던 브라이언은 광고글이 일정한 규칙에 의해 만들어진다는 사실을 알게 되었는데, 그 규칙은 다음과 같다.
(아래 설명 및 그 이후의 내용에서 영문 대문자는 원래 문구, 소문자는 특수기호를 의미한다.)

광고글은 원래 문구에 다음 규칙을 적용하여 만들 수 있다.
(규칙 1) 특정 단어를 선택하여 글자 사이마다 같은 기호를 넣는다. ex) HELLO -> HaEaLaLaO
(규칙 2) 특정 단어를 선택하여 단어 앞뒤에 같은 기호를 넣는다. ex) WORLD -> bWORLDb
위의 두 가지 규칙은 한 단어에 모두 적용될 수 있지만 같은 규칙은 두 번 적용될 수 없다.
한 번 쓰인 소문자(특수기호)는 다시 쓰일 수 없다.
마지막으로 원래 문구에 있던 공백을 제거한다.
위의 규칙에 따라, HELLO WORLD는 다음의 광고 문구로 변환될 수 있다.

HELLOWORLD (기호 삽입 없이 마지막 규칙인 공백 제거만 적용되었다.)
HaEaLaLaObWORLDb (첫 번째 단어에는 규칙 1이, 두 번째 단어에는 규칙 2가 적용되었다.)
aHbEbLbLbOacWdOdRdLdDc (모든 단어에 모든 규칙이 적용되었다.)
단, 아래의 문구는 올바르게 변환된 광고문구가 아니다.

aHELLOa bWORLDb (공백이 제거되어야 한다.)
HaEaLaLObWORLDb (규칙 1은 단어의 모든 글자 사이에 적용되어야 한다. 단, 이 문장은 원문이 HELL O WORLD인 경우 올바른 변환이다.)
aHELLOWORLDa (규칙 2는 한 단어에 적용되어야 한다. 단, 이 문장은 원문이 HELLOWORLD인 경우 올바른 변환이다.)
HaEaLaLaOWaOaRaLaD (첫 번째 단어에 쓰인 기호 a를 두 번째 단어에 쓸 수 없다.)
abHELLObaWORLD (하나의 규칙을 같은 단어에 두 번 적용할 수 없다.)
신고된 글에 대해 위 규칙이 적용되기 전 문구를 찾을 수 있으면 자동 차단 시스템을 다시 온전하게 실행할 수 있게 된다. 카카오스토리가 광고글 없는 깨끗한 공간이 될 수 있도록 프로그램을 만들어보자.

입력 형식
입력은 문자열 변수 sentence로 주어진다. 이 문자열은 영문 대소문자로만 이루어져 있으며, 길이는 1,000 이하이다.

출력 형식
입력으로 주어진 광고 문구의 규칙 적용 전 원래 문구를 리턴한다. 단 원래 문구의 경우 문장 앞뒤의 공백이 없어야 하며, 단어 사이의 공백은 한 글자여야 한다. 가능한 답이 여러 가지인 경우 그중 하나를 리턴하면 된다. 규칙에 따른 변환으로 만들 수 없는 문자열이 입력된 경우에는 소문자로 invalid를 리턴한다.

예제 입출력
sentence				answer
"HaEaLaLaObWORLDb"		"HELLO WORLD"
"SpIpGpOpNpGJqOqA"		"SIGONG JOA"
"AxAxAxAoBoBoB"			"invalid"

예제에 대한 설명
첫 번째 테스트 케이스는 문제 설명에 제시된 데이터와 같다.
두 번째 테스트 케이스에서, 기호 q는 규칙 1, 혹은 규칙 2에 의해 추가된 기호일 수 있다. 규칙 1에 해당하는 경우 원문은 SIGONG JOA로 예제 출력과 같으며, 규칙 2에 해당하는 경우의 원문인 SIGONG J O A도 올바른 답이다.
세 번째 테스트 케이스에서 x는 규칙 1에 의해 추가된 기호여야 한다. (규칙 2에 의해 추가되었다면 기호가 단어 앞뒤에 붙게 되므로 2개여야 한다.) 그러므로 AAAA가 한 단어여야 한다. 마찬가지로 o도 규칙 1에 의해 추가된 기호여야 하기 때문에 ABBB가 한 단어여야 한다. 이는 동시에 만족할 수 없는 조건이므로 주어진 문구는 규칙을 만족할 수 없게 된다. 따라서 invalid를 리턴한다.

*/
