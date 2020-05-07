import { Question } from './question';

export class Test {

    testId:number;
    testTitle:string;
    testDuration:string;
    startTime:string;
    endTime:string;
    testQuestions:Question[]=[];
    testTotalMarks:number;
    testMarksScored:number;
}
