package com.practice.oct16;

public class GetMaxSum {
	private static int getMaxSum(int[] array, int n) {
		int temp = 0;
		int max = -(1 << 30);
		for (int i = 0; i < n; ++i) {
			temp += array[i];
			max = Math.max(temp, max);
			if (temp < 0) {
				temp = 0;
			}

		}
		return max;
	}

	public static void main(String[] args) {
		int[] array = { -1284747, -249931, 1307528, -1263052, -1201165, -1486987, 156190, -290714, 999602, -46548,
				809634, 981418, 123127, 901786, -381024, -181818, 260828, -1389442, -1186981, 623747, -1340182, 505366,
				1224046, 1357972, -1026795, -1206979, -1301393, 1440080, -160069, -125893, -1017909, 725718, 834753,
				-1257496, 224439, 443509, 276943, -807306, 1398731, 203712, 55051, 542474, -1476778, 1322930, 1179555,
				240739, 1225098, -650143, -580854, -1174459, -868671, -10150, 1209420, 1428811, -747570, 1024167,
				860489, -333008, -600034, -265934, 1152844, -77222, 1031483, 1067054, -1313758, -943161, 491855,
				-1269833, 761888, 1238196, -688952, -1080413, -796591, -889635, 215296, -295387, 648612, -84399,
				-1221968, -516627, 551856, -402146, -1481737, -257142, -1269213, -1076456, 1386182, 645110, 439763,
				1296097, 941176, -433817, 276038, -488995, 523697, -154874, -1445325, -495518, -223049, -259452,
				1184959, 1116543, 965963, -735865, -461662, -1391291, -916359, 1355128, -170791, 255327, -291009,
				484195, 666192, -619919, 1299269, -61348, 1364741, -1206238, -1189981, 1146211, 1196970, 827316,
				-809229, 785733, 1238342, -666939, -34856, 622349, -714405, -680224, -1153651, -120004, -1312767,
				-71488, 577867, -1422431, -69475, -1027478, -1437145, -842588, 744097, -283585, 1299154, 34981, -640257,
				-999863, 841287, -333132, 364497, 99802, 644036, 587885, -1375832, -24194, 1123097, 726454, 151697,
				158603, -1011239, -1397306, 789953, -1444109, -1064734, -1164158, -432980, 989990, 620053, 554199,
				464687, 1319803, -853441, 1328613, 74364, -561277, -111218, 445239, 17137, -305994, -1282939, -1364156,
				383295, -784012, 792388, 505442, -872001, -927166, 1507267, -1294997, 1130127, 1006879, 121334, 633135,
				110247, 1215383, -234187, -424948, -354288, -1309789, -576801, -116518, 701847, -166814, 797457,
				-1434174, -138327, -322516, 118919, -1296534, 738443, -113131, 634134, 1096828, -157647, 690393, -27968,
				270337, -1219146, 971627, -421980, 554970, 326047, -1084732, 110017, -289054, -1070506, 1156696,
				-581195, -143129, -785668, 755859, 677561, -458736, -1271818, 1452281, -1090356, 795718, -691819,
				-626718, 125312, 105771, -772126 };
		int n = array.length;
		int res = getMaxSum(array, n);
		System.out.println(res);
	}
}
