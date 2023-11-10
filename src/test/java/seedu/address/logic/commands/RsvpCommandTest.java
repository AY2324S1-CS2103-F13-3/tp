package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalEvents.ACADEMIC;
import static seedu.address.testutil.TypicalPersons.ALICE;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.rsvp.Rsvp;
import seedu.address.model.rsvp.RsvpStatus;

public class RsvpCommandTest {

    private final Model model = new ModelManager();

    @Test
    public void constructor_nullRsvp_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new RsvpCommand(null, null, null));
    }

    @Test
    public void execute_nullRsvp_throwsCommandException() {
        Index invalidIndex = Index.fromZeroBased(0);
        RsvpCommand rsvpCommand = new RsvpCommand(invalidIndex, invalidIndex, RsvpStatus.CC);
        assertThrows(CommandException.class, () -> rsvpCommand.execute(model));
    }

    @Test
    public void execute_invalidRsvp_throwsCommandException() {
        Person newPerson = new Person(new Name("Dom"), new Phone("9213"), new Email("dom@gma.com"));
        model.addPerson(newPerson);
        model.addEvent(ACADEMIC);
        Index validIndex = Index.fromZeroBased(0);
        RsvpCommand rsvpCommand = new RsvpCommand(validIndex, validIndex, RsvpStatus.CC);
        assertThrows(CommandException.class, () -> rsvpCommand.execute(model));
    }

//    @Test
//    public void execute_rsvpCommand_success() {
//        model.addPerson(ALICE);
//        model.addEvent(ACADEMIC);
//        Index validIndex = Index.fromZeroBased(0);
//        RsvpCommand rsvpCommand = new RsvpCommand(validIndex, validIndex, RsvpStatus.CC);
//
//        Model expectedModel = new ModelManager();
//        expectedModel.addPerson(ALICE);
//        expectedModel.addEvent(ACADEMIC);
//        expectedModel.addRsvp(new Rsvp(ACADEMIC, ALICE, RsvpStatus.CC));
//
//        String expectedSuccessMessage =
//                String.format(RsvpCommand.MESSAGE_SUCCESS, ACADEMIC.getName(), ALICE.getName(),
//                        RsvpStatus.CC.getStatus());
//        assertCommandSuccess(rsvpCommand, model, expectedSuccessMessage, expectedModel);
//    }
}
