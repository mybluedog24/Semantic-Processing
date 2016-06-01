package semanticprocessing;

import java.io.Serializable;

/**
 * Contains the result of searching a facultyMember for a given list keywords.
 * Stores info on how many times each of those given keywords show up on the
 * facultyMember.
 * Instances of this class are created mainly be the search class.
 * @author Isiah
 */
public class Result implements Comparable<Result>, Serializable {

    /** The facultyMember whose results are in this instance. */
    // facultyMember contains all the pages of URLs of one faculty member.
    //It has the home page and all the links linking to more info on
    //one faculty member.
    private FacultyMember facultyMember;
    /** The relevancy score given to this facultyMember. Must be positive */
    private double score;

    /**
     * Constructs a new facultyMember with its score value.
     * @param member The facultyMember whose results are stored in this
     * instance.
     * @param memberScore The relevancy score given to this facultyMember.
     */
    public Result(final FacultyMember member, final double memberScore) {
        this.facultyMember = member;
        this.score = memberScore;
    }

    /**
     * Gets the facultyMember whose results are stored in this instance.
     * @return A facultyMember instance associated with this result.
     */
    public final FacultyMember getPage() {
        return facultyMember;
    }

    /**
     * Retrieves the score of this facultyMember.
     * @return <code>score</code> - An integer representing the relevancy score
     * of this facultyMember.
     */
    public final double getScore() {
        return score;
    }

    /**
     * Compares the score of this Result object, against the parameter's Result
     * object.
     * @param other The other object to compare to.
     * @return A positive number if the current object has a higher score than
     *  <code>other</code>. A negative otherwise, and 0 if equal.
     */
    public final int compareTo(final Result other) {
        // Nested if statements to convert double to int.
        if (getScore() > other.getScore()) {
            return 1;
        } else {
            if (getScore() < other.getScore()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    /**
     * Returns the Result Main URL and Score in a String.
     * @return A String of (mainURL + " " + 0)
     */
    @Override
    public final String toString() {
        return facultyMember.getMainURL().toString() + " " + score;
    }
}
