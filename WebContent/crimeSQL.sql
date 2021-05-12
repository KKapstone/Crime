create table crimes(
	cid varchar(20) not null,
	year int (11),
	region varchar(30),
	murder int (11),
	sex_violence int (11),
	assault int (11),
	intrud int (11), 
	primary key(cid)
);
select * from crimes;

insert into crimes(cid, year, region, murder, sex_violence, assault, intrud) values("C0001",	2014,	"종로",	2,	307,	11,	63);
insert into crimes values("C0002",	2014,	"중구",	6,	377,	19,	44);
insert into crimes values("C0003",	2014,	"용산",	1,	269,	7,	62);
insert into crimes values("C0004",	2014,	"성동",	1,	187,	5,	48);
insert into crimes values("C0005",	2014,	"광진",	8,	328,	13,	120);
insert into crimes values("C0006",	2014,	"동대문",	12,	210,	13,	56);
insert into crimes values("C0007",	2014,	"중랑",	11,	205,	6,	116);
insert into crimes values("C0008",	2014,	"성북",	8,	220,	14,	88);
insert into crimes values("C0009",	2014,	"강북",	6,	220,	10,	46);
insert into crimes values("C0010",	2014,	"도봉",	6,	208,	4,	36);
insert into crimes values("C0011",	2014,	"노원",	5,	294,	4,	52);
insert into crimes values("C0012",	2014,	"은평",	5,	222,	14,	67);
insert into crimes values("C0013",	2014,	"서대문",	3,	867,	7,	78);
insert into crimes values("C0014",	2014,	"마포",	4,	423,	29,	87);
insert into crimes values("C0015",	2014,	"양천",	5,	241,	11	,62);
insert into crimes values("C0016",	2014,	"강서",	8,	308,	12,	73);
insert into crimes values("C0017",	2014,	"구로",	4,	426,	10,	87);
insert into crimes values("C0018",	2014,	"금천",	8,	250,	5,	44);
insert into crimes values("C0019",	2014,	"영등포",	13,	352,	23,	80);
insert into crimes values("C0020",	2014,	"동작",	2,	437,	17,	85);
insert into crimes values("C0021",	2014,	"관악",	7,	471,	19,	148);
insert into crimes values("C0022",	2014,	"서초",	6,	448,	13,	59);
insert into crimes values("C0023",	2014,	"강남",	12,	761,	18,	155);
insert into crimes values("C0024",	2014,	"송파",	9,	383,	23,	103);
insert into crimes values("C0025",	2014,	"강동",	5,	180,	10,	59);
insert into crimes values();
