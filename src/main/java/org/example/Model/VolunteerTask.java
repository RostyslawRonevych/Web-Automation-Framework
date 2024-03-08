package org.example.Model;

import org.instancio.Instancio;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;

import static org.instancio.Select.field;

public class VolunteerTask {
    String taskName;
    int category;
    String expDate;
    String taskDescription;
    String outputDescription;
    String reward;
    String requirements;
    boolean interview;
    String moneySum;
    int currency;
    String step0Name;
    String step0Duration;
    int step0Measurement;
    String step0Description;
    String step1Name;
    String step1Duration;
    int step1Measurement;
    String step1Description;

    public static Stream<VolunteerTask> createVolunteerTaskStreamValid() {
        List<VolunteerTask> list = Instancio.ofList(VolunteerTask.class)
                .size(1)
                .generate(field(VolunteerTask::getTaskName), gen -> gen.text().pattern("Task: #C#c#c#c#c#c"))
                .generate(field(VolunteerTask::getCategory), gen -> gen.ints().min(1).max(10))
                .generate(field(VolunteerTask::getExpDate), gen -> gen.temporal().localDate().future().as(dob -> dob.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))))
                .generate(field(VolunteerTask::getTaskDescription), gen -> gen.text().pattern("Description #d#d#d#d#d"))
                .generate(field(VolunteerTask::getOutputDescription), gen -> gen.text().pattern("#C#C#d#c#c#d#d#d#d#d"))
                .generate(field(VolunteerTask::getReward), gen -> gen.text().pattern("#C#C#d#c#c#d#d#d#d#d"))
                .generate(field(VolunteerTask::getRequirements), gen -> gen.text().pattern("#C#c#c#c#c#c"))
                .generate(field(VolunteerTask::isInterview), gen -> gen.booleans())
                .generate(field(VolunteerTask::getMoneySum), gen -> gen.text().pattern("#d#d#d#d#d"))
                .generate(field(VolunteerTask::getCurrency), gen -> gen.ints().min(0).max(2))
                .generate(field(VolunteerTask::getStep0Name), gen -> gen.text().pattern("Step 0 name: #d#d#d#d#d"))
                .generate(field(VolunteerTask::getStep0Duration), gen -> gen.text().pattern("5"))
                .generate(field(VolunteerTask::getStep0Measurement), gen -> gen.ints().min(0).max(0))
                .generate(field(VolunteerTask::getStep0Description), gen -> gen.text().pattern("Step 0 description: #d#d#d#d#d"))
                .generate(field(VolunteerTask::getStep1Name), gen -> gen.text().pattern("Step 0 name: #d#d#d#d#d"))
                .generate(field(VolunteerTask::getStep1Duration), gen -> gen.text().pattern("5"))
                .generate(field(VolunteerTask::getStep1Measurement), gen -> gen.ints().min(0).max(0))
                .generate(field(VolunteerTask::getStep1Description), gen -> gen.text().pattern("Step 0 description: #d#d#d#d#d"))
                .create();
        Stream<VolunteerTask> volunteerTaskStream = list.stream();
        return volunteerTaskStream;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public int getCategory() {
        return this.category;
    }

    public String getExpDate() {
        return this.expDate;
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }

    public String getOutputDescription() {
        return this.outputDescription;
    }

    public String getReward() {
        return this.reward;
    }

    public String getRequirements() {
        return this.requirements;
    }

    public boolean isInterview() {
        return this.interview;
    }

    public String getMoneySum() {
        return this.moneySum;
    }

    public int getCurrency() {
        return this.currency;
    }

    public String getStep0Name() {
        return this.step0Name;
    }

    public String getStep0Duration() {
        return this.step0Duration;
    }

    public int getStep0Measurement() {
        return this.step0Measurement;
    }

    public String getStep0Description() {
        return this.step0Description;
    }

    public String getStep1Name() {
        return this.step1Name;
    }

    public String getStep1Duration() {
        return this.step1Duration;
    }

    public int getStep1Measurement() {
        return this.step1Measurement;
    }

    public String getStep1Description() {
        return this.step1Description;
    }
}
